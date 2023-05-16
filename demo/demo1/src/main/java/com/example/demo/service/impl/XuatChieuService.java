package com.example.demo.service.impl;

import com.example.demo.model.XuatChieu;
import com.example.demo.repository.IXuatChieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class XuatChieuService implements com.example.demo.service.IXuatChieuService {
    @Autowired
    private IXuatChieuRepository iXuatChieuRepository;
    @Override
    public List<XuatChieu> getAll() {
        return iXuatChieuRepository.findAll();
    }

    @Override
    public void save(XuatChieu xuatChieu) {
        iXuatChieuRepository.save(xuatChieu);
    }

    @Override
    public void detete(int id) {
        iXuatChieuRepository.deleteById(id);
    }
}
