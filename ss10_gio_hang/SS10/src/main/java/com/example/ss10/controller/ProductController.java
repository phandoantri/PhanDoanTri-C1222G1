package com.example.ss10.controller;

import com.example.ss10.dto.CartDTO;
import com.example.ss10.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
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
            if (arrayIds.length>=3){
                idString=id+SEPARATOR+arrayIds[0]+SEPARATOR+arrayIds[1];
            }else {
                idString=id+SEPARATOR+ids;
            }
            cookie=new Cookie("seenProductIds",idString);
        }
        cookie.setMaxAge(24*60*60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return "/detail";
    }
}
