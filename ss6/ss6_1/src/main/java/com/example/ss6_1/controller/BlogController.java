package com.example.ss6_1.controller;

import com.example.ss6_1.model.Blog;
import com.example.ss6_1.model.TypeBlog;
import com.example.ss6_1.service.IBlogService;
import com.example.ss6_1.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ITypeBlogService iTypeBlogService;

    @GetMapping()
    public String showListBlog(Model model,
                               @PageableDefault(size = 1) Pageable pageable) {
        model.addAttribute("blogList", this.iBlogService.getAll(pageable));
        return "/blogs/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("typeBlog", this.iTypeBlogService.getAll());
        return "/blogs/create";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute Blog blog) {
        this.iBlogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/deleteBlog")
    public String deleteBlog(@RequestParam(value = "id") int id) {
        iBlogService.delete(id);
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/update")
    public String updateForm(@PathVariable int id, Model model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("typeBlog",iTypeBlogService.getAll());
        return "/blogs/update";
    }
    @PostMapping("/updateBlog")
    private String update(Blog blog){
        iBlogService.update(blog);
        return "redirect:/blogs";
    }
    @GetMapping("/{id}/detail")
    public String detailProduct(@PathVariable(value = "id") int id, Model model) {
        Blog blog=iBlogService.findById(id);
        model.addAttribute("blog", blog);
        List<TypeBlog> typeBlogs=iTypeBlogService.getAll();
        model.addAttribute("typeBlog",typeBlogs);
        return "/blogs/detail";
    }

}
