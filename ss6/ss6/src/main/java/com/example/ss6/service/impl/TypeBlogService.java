package com.example.ss6.service.impl;

import com.example.ss6.model.TypeBlog;
import com.example.ss6.repository.ITypeBlogRepository;
import com.example.ss6.service.ITypeBlogService;
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
