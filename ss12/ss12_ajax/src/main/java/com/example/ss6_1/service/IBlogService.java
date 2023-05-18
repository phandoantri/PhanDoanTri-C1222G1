package com.example.ss6_1.service;

import com.example.ss6_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> getAll(Pageable pageable);

    List<Blog> findByName(String name);

   Optional<Blog>  findById(int id);

}
