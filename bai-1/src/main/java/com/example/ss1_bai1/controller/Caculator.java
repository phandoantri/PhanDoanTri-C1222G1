package com.example.ss1_bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Caculator {
    @GetMapping ("/calculator")
    public  String result(@RequestParam(defaultValue = "0") int vnd, Model model){
        int  result=vnd*23000;
        model.addAttribute("result", result);
        return "/list";
    }
}
