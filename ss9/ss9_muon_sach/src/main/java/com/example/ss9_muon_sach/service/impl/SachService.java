package com.example.ss9_muon_sach.service.impl;

import com.example.ss9_muon_sach.model.Sach;
import com.example.ss9_muon_sach.repository.ISachRepository;
import com.example.ss9_muon_sach.service.ISachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SachService implements ISachService {
    @Autowired
    private ISachRepository iSachRepository;
    @Override
    public List<Sach> getAll() {
        return iSachRepository.findAll();
    }

    @Override
    public Sach finById(int id) {
        return iSachRepository.findById(id).get();
    }
}
