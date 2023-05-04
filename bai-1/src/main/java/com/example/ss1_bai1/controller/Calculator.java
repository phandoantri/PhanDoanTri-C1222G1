package com.example.ss1_bai1.controller;

import com.example.ss1_bai1.service.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calculator {
    private CalculatorService calculatorService = new CalculatorService();

    @GetMapping("/calculator")
    public String result(@RequestParam(defaultValue = "0") int vnd, Model model) {
        int result = calculatorService.result(vnd);
        model.addAttribute("result", result);
        return "/list";
    }
}
