package com.example.ss6.controller;

import com.example.ss6.model.Blog;
import com.example.ss6.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("blogList", this.iBlogService.findAll());
        return "/blogs/list";
    }

    @GetMapping("/create-form")
    public String CreateForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blogs/create";
    }

}
