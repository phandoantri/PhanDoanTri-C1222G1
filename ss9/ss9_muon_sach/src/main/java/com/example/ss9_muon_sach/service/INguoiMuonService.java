package com.example.ss9_muon_sach.service;

import com.example.ss9_muon_sach.model.PhieuMuon;

import java.util.List;

public interface INguoiMuonService {
    List<PhieuMuon> getAll();
    PhieuMuon findById(int id);
    void save(PhieuMuon phieuMuon);
}
