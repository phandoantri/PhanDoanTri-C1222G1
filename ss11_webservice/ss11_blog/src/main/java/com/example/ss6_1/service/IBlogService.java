package com.example.ss6_1.service;

import com.example.ss6_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();

    List<Blog> findByName(String name);

    Blog findById(int id);

}
