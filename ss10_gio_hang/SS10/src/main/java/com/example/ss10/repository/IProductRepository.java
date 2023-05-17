package com.example.ss10.repository;

import com.example.ss10.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByIdIn(Set<Integer> ids);
}
