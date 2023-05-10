package com.example.ss6_1.service;

import com.example.ss6_1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    void save(Blog blog);
    void delete(int id);
    Blog findById(int id);
    void update(Blog blog);
}
