package com.example.ss4.service.iplm;

import com.example.ss4.model.Product;
import com.example.ss4.repository.IProductRepository;
import com.example.ss4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<Product> getAll() {
        List<Product> productList=iProductRepository.getAll();
        for (Product product:productList){
            System.out.println(product);
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);

    }

    @Override
    public void delete(int id) {
        iProductRepository.delete(id);
    }
}
