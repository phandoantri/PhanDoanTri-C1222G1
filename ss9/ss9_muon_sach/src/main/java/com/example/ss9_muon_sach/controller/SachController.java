package com.example.ss9_muon_sach.controller;

import com.example.ss9_muon_sach.model.PhieuMuon;
import com.example.ss9_muon_sach.model.Sach;
import com.example.ss9_muon_sach.service.INguoiMuonService;
import com.example.ss9_muon_sach.service.ISachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sach")
public class SachController {
    @Autowired
    private ISachService iSachService;
    @Autowired
    private INguoiMuonService iNguoiMuonService;

    @GetMapping()
    public String showListSach(Model model) {
        model.addAttribute("sachList", iSachService.getAll());
        return "/sach/list";
    }

    @GetMapping("/{id}/muon")
    public String muonSach(@PathVariable int id) throws Exception {
        PhieuMuon phieuMuon = new PhieuMuon();
        int maMuon = (int) (Math.random() * (99999 - 10000) + 10000);
        phieuMuon.setMaMuon(maMuon);
        long thoiGian = System.currentTimeMillis();
        phieuMuon.setNgayMuon(new java.sql.Date(thoiGian));
        Sach sach = iSachService.finById(id);
        sach.setSoLuong(sach.getSoLuong() - 1);
        if (sach.getSoLuong()==0){
            throw new Exception();
        }

        List<PhieuMuon> phieuMuons = sach.getPhieuMuons();
        phieuMuons.add(phieuMuon);
        sach.setPhieuMuons(phieuMuons);
        iNguoiMuonService.save(phieuMuon);
        iSachService.save(sach);
        return "redirect:/sach";
    }


}
