package com.example.ss10.dto;

import com.example.ss10.model.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartDTO {
    private final Map<Integer, Integer> selectedProduct;


    public CartDTO() {
        this.selectedProduct = new LinkedHashMap<>();
    }

    public Map<Integer, Integer> getSelectedProduct() {
        return selectedProduct;
    }
}
