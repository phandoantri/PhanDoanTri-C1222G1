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
    private IOrderRepository iOrderRepository;
    @Override
    public List<Order> getAll() {
        return iOrderRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return iOrderRepository.findById(id).get();
    }

    @Override
    public void save(Order order) {
        iOrderRepository.save(order);
    }

    @Override
    public boolean findByCode(int code) {
        List<Order> orderList=iOrderRepository.findAll();
        for (int i=0;i<orderList.size();i++){
            if (orderList.get(i).getCode()==code){
                return true;
            }
        }
        return false;
    }


}
