package com.example.ss6_1.service.impl;

import com.example.ss6_1.model.Blog;
import com.example.ss6_1.repository.IBlogRepository;
import com.example.ss6_1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public Page<Blog> getAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.getById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }
}
