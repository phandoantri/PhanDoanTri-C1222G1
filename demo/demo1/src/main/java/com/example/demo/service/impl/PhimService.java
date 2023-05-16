package com.example.demo.service.impl;

import com.example.demo.model.Phim;
import com.example.demo.repository.IPhimRepository;
import com.example.demo.service.IPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhimService implements IPhimService {
    @Autowired
    private IPhimRepository iPhimRepository;
    @Override
    public List<Phim> getAll() {
        return iPhimRepository.findAll() ;
    }

    @Override
    public void save(Phim phim) {
        iPhimRepository.save(phim);
    }
}
