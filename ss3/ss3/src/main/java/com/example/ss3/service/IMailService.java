package com.example.ss3.service;

import com.example.ss3.model.Mail;

import java.util.List;

public interface IMailService {
    List<Mail> getAll();
    void update(Mail mail);
}
