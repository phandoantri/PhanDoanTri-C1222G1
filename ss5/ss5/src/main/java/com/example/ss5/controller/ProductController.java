package com.example.ss5.controller;

import com.example.ss5.model.Product;
import com.example.ss5.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("productList", this.iProductService.getAll());
        return "/list";
    }
    @GetMapping("/create-form")
    public String createNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping()
    public String create(@ModelAttribute Product product) {
        this.iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(Product product) {
        iProductService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value = "id")int id){
        iProductService.delete(id);
        return "redirect:/product";
    }
    @GetMapping("/searchByNameProduct")
        public String searchProductByName(@RequestParam (value = "nameProduct")String nameProduct, Model model){
        model.addAttribute("productList", iProductService.searchByNameProduct(nameProduct));
        return "/list";
    }


}
