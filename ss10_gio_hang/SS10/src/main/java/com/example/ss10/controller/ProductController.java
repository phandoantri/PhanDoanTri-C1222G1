package com.example.ss10.controller;

import com.example.ss10.dto.CartDTO;
import com.example.ss10.dto.ProductFromCartDTO;
import com.example.ss10.model.Product;
import com.example.ss10.service.ICartService;
import com.example.ss10.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
@SessionAttributes(value = "cartDTO")
public class ProductController {
    @ModelAttribute(name = "cartDTO")
    private CartDTO initCartDTO() {
        return new CartDTO();
    }

    @Autowired
    private IProductService iProductService;
    @Autowired
    private ICartService iCartService;


    private static final String SEPARATOR = "-";

    @GetMapping()
    public String showListProduct(Model model) {
        model.addAttribute("productList", iProductService.getAll());
        return "/list";
    }

    @GetMapping("/{id}/detail")
    public String detailProduct(Model model, @PathVariable(name = "id") int id,
                                @CookieValue(name = "seenProductIds", defaultValue = "") String ids,
                                HttpServletResponse response) {
        model.addAttribute("product", iProductService.getProductById(id));
        Cookie cookie;
        if ("".equals(ids)) {
            cookie = new Cookie("seenProductIds", Integer.toString(id));
        } else {
            String idString;
            String[] arrayIds = ids.split(SEPARATOR);
            if (arrayIds.length >= 3) {
                idString = id + SEPARATOR + arrayIds[0] + SEPARATOR + arrayIds[1];
            } else {
                idString = id + SEPARATOR + ids;
            }
            cookie = new Cookie("seenProductIds", idString);
        }
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return "/detail";
    }

    @GetMapping("/{id}/addToCart")
    public String addToCart(@PathVariable(name = "id") int id, @SessionAttribute(name = "cartDTO") CartDTO cartDTO,
                            Model model) {
        Product product = iProductService.getProductById(id);
        boolean addProduct = false;
        for (Map.Entry<Integer, Integer> entry : cartDTO.getSelectedProduct().entrySet()) {
            if (entry.getKey() == product.getId()) {
                entry.setValue(entry.getValue() + 1);
                addProduct = true;
            }
        }
        if (!addProduct) {
            cartDTO.getSelectedProduct().put(product.getId(), 1);
        }
        model.addAttribute("mess", "add product to cart");
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String getProductsFromCart(@SessionAttribute(name = "cartDTO") CartDTO cartDTO, Model model) {
        Set<Integer> productIds = cartDTO.getSelectedProduct().keySet();

        Map<Integer, Product> mapProducts = iProductService.getListProductByIds(productIds).stream()
                .collect(Collectors.toMap(Product::getId, p -> p));

        List<ProductFromCartDTO> products = cartDTO.getSelectedProduct().entrySet().stream().
                map(e -> new ProductFromCartDTO(e.getKey()
                        , mapProducts.get(e.getKey()).getName(),
                        mapProducts.get(e.getKey()).getPrice(),
                        mapProducts.get(e.getKey()).getLink(),
                        e.getValue(),
                        mapProducts.get(e.getKey()).getPrice() * e.getValue())).
                collect(Collectors.toCollection(LinkedList::new));
        model.addAttribute("total", iCartService.totalBill(products));
        model.addAttribute("products", products);
        return "/cart";
    }

    @GetMapping("/delete")
    public String deleteProduct(@SessionAttribute(name = "cartDTO") CartDTO cartDTO, @RequestParam(name = "idDelete") int id) {
        Map<Integer, Integer> cartDto = cartDTO.getSelectedProduct();
        cartDto.remove(id);
        return "redirect:/products";
    }

    @GetMapping("/{id}/increase")
    public String increase(@PathVariable(name = "id") int id, @SessionAttribute(name = "cartDTO") CartDTO cartDTO) {
        for (Map.Entry<Integer, Integer> entry : cartDTO.getSelectedProduct().entrySet()) {
            if (entry.getKey() == id) {
                entry.setValue(entry.getValue() + 1);
            }
        }
        return "redirect:/products/cart";
    }

    @GetMapping("{id}/decrease")
    public String decrease(@PathVariable(name = "id") int id, @SessionAttribute(name = "cartDTO") CartDTO cartDTO) {
        for (Map.Entry<Integer, Integer> entry : cartDTO.getSelectedProduct().entrySet()) {

            if (entry.getKey() == id) {
                if (entry.getValue() == 1) {
                    Map<Integer, Integer> cartDto = cartDTO.getSelectedProduct();
                    cartDto.remove(id);
                    return "redirect:/products/cart";
                } else {
                    entry.setValue(entry.getValue() - 1);
                }

            }
        }
        return "redirect:/products/cart";
    }

    @GetMapping("/pay")
    public String pay(@SessionAttribute(name = "cartDTO") CartDTO cartDTO, Model model) {
        cartDTO.getSelectedProduct().clear();
        model.addAttribute("mess", "pay success");
        return "/cart";
    }

}
