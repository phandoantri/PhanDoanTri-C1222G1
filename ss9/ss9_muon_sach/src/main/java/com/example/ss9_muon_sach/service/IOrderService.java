package com.example.ss9_muon_sach.service;

import com.example.ss9_muon_sach.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    Order findById(int id);
    void save(Order phieuMuon);
}
