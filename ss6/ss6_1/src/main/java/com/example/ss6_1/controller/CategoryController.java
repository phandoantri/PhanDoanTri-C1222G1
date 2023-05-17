package com.example.ss6_1.controller;

import com.example.ss6_1.model.TypeBlog;
import com.example.ss6_1.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ITypeBlogService iTypeBlogService;

    @GetMapping()
    public List<TypeBlog> showListTypeBlog() {
        return iTypeBlogService.getAll();
    }
}
