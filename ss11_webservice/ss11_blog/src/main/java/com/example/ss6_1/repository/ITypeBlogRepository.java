package com.example.ss6_1.repository;

import com.example.ss6_1.model.Blog;
import com.example.ss6_1.model.TypeBlog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITypeBlogRepository extends JpaRepository<TypeBlog,Integer> {
    List<Blog> findById(int id);
}
