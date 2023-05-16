package com.example.ss10.service;

import com.example.ss10.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product getProductById(int id);
}
