package com.example.ss6_1.controller;

import com.example.ss6_1.model.Blog;
import com.example.ss6_1.model.TypeBlog;
import com.example.ss6_1.service.IBlogService;
import com.example.ss6_1.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ITypeBlogService iTypeBlogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> showListBlog() {
        List<Blog> blogList=this.iBlogService.getAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
       return new ResponseEntity<>(blogList, HttpStatus.OK);

    }
    @GetMapping("/findListBlog/{name}")
    public ResponseEntity<List<Blog>> listBlog(@PathVariable String name){
        List<Blog> blogList=this.iBlogService.findByName(name);
        if (!blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<Blog> listBlog(@PathVariable int id){
        Optional<Blog> blog=this.iBlogService.findById(id);
        if (!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }
}
