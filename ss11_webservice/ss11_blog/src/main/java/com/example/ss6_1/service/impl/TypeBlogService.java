package com.example.ss6_1.service.impl;

import com.example.ss6_1.model.Blog;
import com.example.ss6_1.model.TypeBlog;
import com.example.ss6_1.repository.ITypeBlogRepository;
import com.example.ss6_1.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeBlogService implements ITypeBlogService {
    @Autowired
    private ITypeBlogRepository iTypeBlogRepository;
    @Override
    public List<TypeBlog> getAll() {
        return iTypeBlogRepository.findAll();

    }


}
