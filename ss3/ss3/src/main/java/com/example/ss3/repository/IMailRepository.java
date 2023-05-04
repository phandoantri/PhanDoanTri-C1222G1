package com.example.ss3.repository;

import com.example.ss3.model.Mail;

import java.util.List;

public interface IMailRepository {
   List<Mail> getAll();
   void update(Mail mail);
}
