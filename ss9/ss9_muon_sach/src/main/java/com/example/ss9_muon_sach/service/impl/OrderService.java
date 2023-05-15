package com.example.ss9_muon_sach.service.impl;

import com.example.ss9_muon_sach.model.Order;
import com.example.ss9_muon_sach.repository.IOrderRepository;
import com.example.ss9_muon_sach.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository iNguoiMuonRepository;
    @Override
    public List<Order> getAll() {
        return iNguoiMuonRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return iNguoiMuonRepository.findById(id).get();
    }

    @Override
    public void save(Order phieuMuon) {
        iNguoiMuonRepository.save(phieuMuon);
    }
}
