package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/save")
public class Sandwich {
    @GetMapping("")
    public String save(@RequestParam(required = false) String [] condiments, Model model ){
        model.addAttribute("condimentsList", Arrays.toString(condiments));
        return "/list";
    }
}
