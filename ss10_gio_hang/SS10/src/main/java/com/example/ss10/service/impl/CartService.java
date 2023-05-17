package com.example.ss10.service.impl;

import com.example.ss10.dto.ProductFromCartDTO;
import com.example.ss10.service.ICartService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService implements ICartService {
    @Override
    public int totalBill(List<ProductFromCartDTO> products) {
        int total=0;
        for (int i = 0; i < products.size(); i++) {
            total+=products.get(i).getTotal();
        }
        return total;
    }
}
