package com.example.ss9_muon_sach.repository;

import com.example.ss9_muon_sach.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order,Integer> {

}
