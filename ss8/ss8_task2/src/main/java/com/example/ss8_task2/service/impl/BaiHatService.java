package com.example.ss8_task2.service.impl;

import com.example.ss8_task2.model.BaiHat;
import com.example.ss8_task2.repository.IBaiHatRepository;
import com.example.ss8_task2.service.IBaiHatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaiHatService implements IBaiHatService {
    @Autowired
    private IBaiHatRepository iBaiHatRepository;

    @Override
    public List<BaiHat> getAll() {
        return iBaiHatRepository.findAll();
    }

    @Override
    public void save(BaiHat baiHat) {
        iBaiHatRepository.save(baiHat);
    }
}
