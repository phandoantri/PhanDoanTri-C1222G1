package com.example.ss9_muon_sach.service.impl;

import com.example.ss9_muon_sach.model.PhieuMuon;
import com.example.ss9_muon_sach.repository.INguoiMuonRepository;
import com.example.ss9_muon_sach.service.INguoiMuonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NguoiMuonService implements INguoiMuonService {
    @Autowired
    private INguoiMuonRepository iNguoiMuonRepository;
    @Override
    public List<PhieuMuon> getAll() {
        return iNguoiMuonRepository.findAll();
    }

    @Override
    public PhieuMuon findById(int id) {
        return iNguoiMuonRepository.findById(id).get();
    }

    @Override
    public void save(PhieuMuon phieuMuon) {
        iNguoiMuonRepository.save(phieuMuon);
    }
}
