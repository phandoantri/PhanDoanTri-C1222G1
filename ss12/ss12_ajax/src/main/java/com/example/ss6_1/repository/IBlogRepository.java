package com.example.ss6_1.repository;

import com.example.ss6_1.model.Blog;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAll(Pageable pageable);
@Query(value = "select * from blog_manager bm join type_blog tb on tb.id_type_blog = bm.id_type_blog where name_type_blog like concat('%', :name, '%')",nativeQuery = true)
    List<Blog> findByName(String name);
}
