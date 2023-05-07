package com.example.ss3.controller;

import com.example.ss3.model.Mail;
import com.example.ss3.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private IMailService iMailService;

    @GetMapping("/update")
    public String getUpdateForm(Model model) {
        model.addAttribute("mail", new Mail());
        List<String> languageList = iMailService.getLanguageList();
        model.addAttribute("listLanguages",languageList );
        List<Integer> pageSize=iMailService.getPageSize();
        model.addAttribute("listPageSize", pageSize);
        return "/update";
    }

    @PostMapping()
    public String updateMail(@ModelAttribute Mail mail) {
        this.iMailService.update(mail);
        return "redirect:/mail/update";
    }
}
