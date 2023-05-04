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

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private IMailService iMailService;

    @GetMapping("/update")
    public String getUpdateForm(Model model) {
        model.addAttribute("mail", new Mail());
        model.addAttribute("listLanguages", new ArrayList<String>() {{
            add("English");
            add("Japanese");
            add("VietNamese");
            add("Chinese");
        }});
        model.addAttribute("listPageSize", new ArrayList<Integer>() {{
            add(5);
            add(10);
            add(15);
            add(50);
            add(100);
        }});
        return "/update";
    }

    @PostMapping()
    public String UpdateMail(@ModelAttribute Mail mail) {
        this.iMailService.update(mail);
        return "redirect:/mail/update";
    }
}
