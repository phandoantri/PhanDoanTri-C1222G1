package com.example.ss10.service;

import com.example.ss10.dto.ProductFromCartDTO;

import java.util.List;

public interface ICartService {

    int totalBill(List<ProductFromCartDTO> products);
}
