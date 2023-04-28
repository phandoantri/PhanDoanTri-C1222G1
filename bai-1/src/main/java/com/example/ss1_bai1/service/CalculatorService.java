package com.example.ss1_bai1.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class CalculatorService {
    public int result(int vnd) {
        int result = vnd * 23000;
        return result;
    }
}