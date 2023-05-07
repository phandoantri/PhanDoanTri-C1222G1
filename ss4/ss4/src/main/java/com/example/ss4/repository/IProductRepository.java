package com.example.ss4.repository;

import com.example.ss4.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();

    void save(Product product);
    Product findById(int id);

    void update(Product product);
    void delete( int id);
}
