package com.example.demo.controller;

import com.example.demo.dto.PhimDTO;
import com.example.demo.dto.XuatChieuDTO;
import com.example.demo.model.Phim;
import com.example.demo.model.XuatChieu;
import com.example.demo.service.IPhimService;
import com.example.demo.service.IXuatChieuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/xuatChieu")
public class XuatChieuController {
    @Autowired
    private IXuatChieuService iXuatChieuService;
    @Autowired
    private IPhimService iPhimService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("xuatChieus", this.iXuatChieuService.getAll());
        model.addAttribute("phim", this.iPhimService.getAll());
        return "/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        model.addAttribute("xuatChieuDTO", new XuatChieuDTO());
        model.addAttribute("phimList", iPhimService.getAll());
        return "/create";
    }
    @PostMapping("/createXuatchieu")
    public String create(@Validated @ModelAttribute(value = "xuatChieuDTO") XuatChieuDTO xuatChieuDTO,
                         BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("xuatChieuDTO", xuatChieuDTO);
            model.addAttribute("phimList", iPhimService.getAll());
            return "/create";
        }
        XuatChieu xuatChieu=new XuatChieu();
        BeanUtils.copyProperties(xuatChieuDTO,xuatChieu);
        this.iXuatChieuService.save(xuatChieu);
        return "redirect:/xuatChieu";
    }
//    @GetMapping("/delete")
//    public String delete(@RequestParam (value = "id")int id){
//        iXuatChieuService.detete(id);
//        return "redirect:/xuatChieu";
//    }
}
