package com.example.demo.service;

import com.example.demo.model.Phim;

import java.util.List;

public interface IPhimService {
    List<Phim> getAll();

    void save(Phim phim);
}
