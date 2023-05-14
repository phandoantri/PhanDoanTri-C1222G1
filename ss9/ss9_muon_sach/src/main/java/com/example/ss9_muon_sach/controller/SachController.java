package com.example.ss9_muon_sach.controller;

import com.example.ss9_muon_sach.exception.ExceptionWhenBorrowError;
import com.example.ss9_muon_sach.exception.ExceptionWhenPayError;
import com.example.ss9_muon_sach.model.PhieuMuon;
import com.example.ss9_muon_sach.model.Sach;
import com.example.ss9_muon_sach.service.INguoiMuonService;
import com.example.ss9_muon_sach.service.ISachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String muonSach(@PathVariable int id) throws ExceptionWhenBorrowError {
        Sach sach = iSachService.finById(id);
        if (sach.getSoLuong() == 0) {
            throw new ExceptionWhenBorrowError();
        }
        sach.setSoLuong(sach.getSoLuong() - 1);

        PhieuMuon phieuMuon = new PhieuMuon();
        int maMuon = (int) (Math.random() * (99999 - 10000) + 10000);
        phieuMuon.setMaMuon(maMuon);
        long thoiGian = System.currentTimeMillis();
        phieuMuon.setNgayMuon(new java.sql.Date(thoiGian));
        List<PhieuMuon> phieuMuons = sach.getPhieuMuons();
        phieuMuons.add(phieuMuon);
        sach.setPhieuMuons(phieuMuons);
        iNguoiMuonService.save(phieuMuon);
        iSachService.save(sach);
        return "redirect:/sach";
    }

    @ExceptionHandler(ExceptionWhenBorrowError.class)
    public String handleException(Exception exception) {
        return "/sach/whenBorrowError";
    }

    @GetMapping("/tra")
    public String traForm() {
        return "/sach/checkCode";
    }

    @GetMapping("/traSach")
    public String traSach(@RequestParam(value = "ma") int ma) throws ExceptionWhenPayError {
        List<Sach> sachs = iSachService.getAll();
        List<PhieuMuon> muons = iNguoiMuonService.getAll();
        for (int i = 0; i < muons.size(); i++) {
            if (muons.get(i).getMaMuon() == ma) {
                sachs.get(i).setSoLuong(sachs.get(i).getSoLuong()+1);
                return "redirect:/sach";
            }
        }
        throw new ExceptionWhenPayError();
    }

    @ExceptionHandler(ExceptionWhenPayError.class)
    public String ExceptionWhenError(Exception exception) {
        return "/sach/whenPayError";
    }

}
