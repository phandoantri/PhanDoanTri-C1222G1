package com.example.ss8.controller;

import com.example.ss8.model.User;
import com.example.ss8.dto.UserDTO;
import com.example.ss8.service.IUserService;
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
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping()
    public String showListUser(Model model) {
        List<User> users = iUserService.getAll();
        model.addAttribute("userList", users);
        return "/users/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/users/create";
    }
    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/users/create";
        }
        User user=new User();
        BeanUtils.copyProperties(userDTO,user);
        this.iUserService.save(user);
        return "redirect:/users";
    }
}
