package com.example.ss10.service.impl;

import com.example.ss10.model.Product;
import com.example.ss10.repository.IProductRepository;
import com.example.ss10.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return iProductRepository.findById(id).get();
    }
}
