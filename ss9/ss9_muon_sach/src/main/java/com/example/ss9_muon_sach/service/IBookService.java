package com.example.ss9_muon_sach.service;

import com.example.ss9_muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book finById(int id);
    void save(Book book);
}
