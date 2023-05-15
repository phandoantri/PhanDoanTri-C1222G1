package com.example.ss9_muon_sach.repository;

import com.example.ss9_muon_sach.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
