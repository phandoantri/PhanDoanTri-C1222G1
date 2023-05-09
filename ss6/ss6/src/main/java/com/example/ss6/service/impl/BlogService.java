package com.example.ss6.service.impl;

import com.example.ss6.model.Blog;
import com.example.ss6.repository.IBlogRepository;
import com.example.ss6.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }
}
