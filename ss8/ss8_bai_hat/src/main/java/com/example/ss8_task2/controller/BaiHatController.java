package com.example.ss8_task2.controller;

import com.example.ss8_task2.dto.BaiHatDTO;
import com.example.ss8_task2.model.BaiHat;
import com.example.ss8_task2.service.IBaiHatService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/baiHat")
public class BaiHatController {
    @Autowired
    private IBaiHatService iBaiHatService;

    @GetMapping()
    public String showListBaiHat(Model model) {
        List<BaiHat> baiHats = iBaiHatService.getAll();
        model.addAttribute("baiHatList", baiHats);
        return "/baiHat/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("baiHatDTO", new BaiHatDTO());
        return "/baiHat/create";
    }

    @PostMapping("/create")
    public String creatBaiHat(@Validated @ModelAttribute(value = "baiHatDTO")
                              BaiHatDTO baiHatDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/baiHat/create";
        }
        BaiHat baiHat = new BaiHat();
        BeanUtils.copyProperties(baiHatDTO, baiHat);
        this.iBaiHatService.save(baiHat);
        return "redirect:/baiHat";
    }

}
