package com.example.demo.service;

import com.example.demo.model.XuatChieu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IXuatChieuService  {
    List<XuatChieu> getAll();

    void save(XuatChieu xuatChieu);

    void detete(int id);
}
