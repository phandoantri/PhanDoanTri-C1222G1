package com.example.ss6_1.controller;

import com.example.ss6_1.model.Blog;
import com.example.ss6_1.model.TypeBlog;
import com.example.ss6_1.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private ITypeBlogService iTypeBlogService;

    @GetMapping()
    public ResponseEntity<List<TypeBlog>> showListTypeBlog() {
        List<TypeBlog> typeBlogList=this.iTypeBlogService.getAll();
        if ((typeBlogList.isEmpty())){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(typeBlogList, HttpStatus.OK);
    }

}
