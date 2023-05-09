package com.example.ss4.controller;

import com.example.ss4.model.Product;
import com.example.ss4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public String getAllProductList(Model model) {
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
        return "redirect:/products";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable(value = "id") int id, Model model) {
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "/update";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(Product product) {
        iProductService.update(product);
        return "redirect:/products";
    }

    @GetMapping("/deleteProduct")
    public String deleteProduct(@RequestParam(value = "id")int id){
        iProductService.delete(id);
        return "redirect:/products";
    }
    @GetMapping("/searchProduct")
    public String searchProduct(@RequestParam (value = "nameProduct")String nameProduct){
        iProductService.searchProduct(nameProduct);
        return "/list";
    }

}
