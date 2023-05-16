package com.example.demo.repository;

import com.example.demo.model.Phim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhimRepository extends JpaRepository<Phim,Integer> {
}
