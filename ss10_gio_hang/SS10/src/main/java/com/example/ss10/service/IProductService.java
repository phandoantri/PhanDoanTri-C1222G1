package com.example.ss10.service;

import com.example.ss10.dto.ProductFromCartDTO;
import com.example.ss10.model.Product;

import java.util.List;
import java.util.Set;

public interface IProductService {
    List<Product> getAll();

    Product getProductById(int id);
    List<Product> getListProductByIds(Set<Integer> ids);


}
