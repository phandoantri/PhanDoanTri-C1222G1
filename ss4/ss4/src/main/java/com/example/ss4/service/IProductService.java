package com.example.ss4.service;

import com.example.ss4.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product findById(int id);
    void save(Product product);
    void update(Product product);
    void delete(int id);
}
