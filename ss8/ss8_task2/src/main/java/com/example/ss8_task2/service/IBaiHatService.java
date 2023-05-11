package com.example.ss8_task2.service;

import com.example.ss8_task2.model.BaiHat;

import java.util.List;

public interface IBaiHatService {
    List<BaiHat> getAll();
    void save(BaiHat baiHat);
}
