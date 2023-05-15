package com.example.ss9_muon_sach.service.impl;

import com.example.ss9_muon_sach.model.Book;
import com.example.ss9_muon_sach.repository.IBookRepository;
import com.example.ss9_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iSachRepository;
    @Override
    public List<Book> getAll() {
        return iSachRepository.findAll();
    }

    @Override
    public Book finById(int id) {
        return iSachRepository.findById(id).get();
    }

    @Override
    public void save(Book sach) {
        iSachRepository.save(sach);
    }
}
