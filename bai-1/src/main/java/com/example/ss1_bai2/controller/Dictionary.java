package com.example.ss1_bai2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    @GetMapping ("/dictionary")
public String search(@RequestParam(defaultValue = "0") String english, Model model){
        String[] english1={"banana","apple","orange","coconut"};
        String[] vietnamese={"chuối","táo","cam","dừa"};
        String message="Không tìm thấy";
        model.addAttribute("word",english);
        for (int i=0;i<english1.length;i++){
            if (english1[i].equals(english)){
                model.addAttribute("vietnamese",vietnamese[i]);
                break;
            }
          model.addAttribute("vietnamese",message);
        }

        return "/listDictionary";
    }
}
