package com.example.ss1_bai2.controller;

import com.example.ss1_bai2.repository.DictionaryRepository;
import com.example.ss1_bai2.repository.IDictionaryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class Dictionary {
    private IDictionaryRepository iDictionaryRepository = new DictionaryRepository();

    @GetMapping("/dictionary")
    public String search(@RequestParam(defaultValue = "0") String english, Model model) {
        String message = "Không tìm thấy";
        model.addAttribute("word", english);
        List<com.example.ss1_bai2.model.Dictionary> dictionaries = iDictionaryRepository.display();
        for (int i = 0; i < dictionaries.size(); i++) {
            if (english.equals(dictionaries.get(i).getEnglish())) {
                model.addAttribute("vietnamese", dictionaries.get(i).getVietnamese());
                break;
            }
            model.addAttribute("vietnamese", message);
        }
        return "/listDictionary";
    }
}
