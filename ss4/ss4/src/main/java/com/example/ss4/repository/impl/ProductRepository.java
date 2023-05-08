package com.example.ss4.repository.impl;

import com.example.ss4.model.Product;
import com.example.ss4.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "milk", 12000));
        productList.add(new Product(2, "coca", 10000));
        productList.add(new Product(3, "sting", 15000));

    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                productList.set(i,product);
                break;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i=0;i<productList.size();i++){
            if (productList.get(i).getId()==id){
                productList.remove(i);
                return;
            }
        }
    }
}
