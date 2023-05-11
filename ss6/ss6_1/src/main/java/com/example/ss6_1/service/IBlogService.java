package com.example.ss6_1.service;

import com.example.ss6_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAll(Pageable pageable);
    void save(Blog blog);
    void delete(int id);
    Blog findById(int id);
    void update(Blog blog);
}
