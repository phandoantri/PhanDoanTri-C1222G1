package com.example.ss2_bai_2.controller;

import com.example.ss2_bai_2.service.CalculatorService;
import com.example.ss2_bai_2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class Calculator {

    private ICalculatorService iCalculatorService = new CalculatorService();

    @GetMapping("/calculator")
    public String calculator(@RequestParam(defaultValue = "0", name = "firstNumber") int firstNumber,
                             @RequestParam(defaultValue = "0", name = "secondNumber") int secondNumber,
                             @RequestParam(defaultValue = "0", value = "calculator") String calculate, Model model) {
        model.addAttribute("result", iCalculatorService.result(calculate, firstNumber, secondNumber));
        return "/list";

    }
}
