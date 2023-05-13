package com.example.ss9_muon_sach.service;

import com.example.ss9_muon_sach.model.Sach;

import java.util.List;

public interface ISachService {
    List<Sach> getAll();
    Sach finById(int id);
    void save(Sach sach);
}
