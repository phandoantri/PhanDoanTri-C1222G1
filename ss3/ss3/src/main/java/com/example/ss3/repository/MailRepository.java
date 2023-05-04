package com.example.ss3.repository;

import com.example.ss3.model.Mail;
import com.example.ss3.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MailRepository implements IMailRepository{
    private static List<Mail> mailList=new ArrayList<>();
    static {
        mailList.add(new Mail(1,"English",25,"Elnable","King"));
    }

    @Override
    public List<Mail> getAll() {
        return mailList;
    }

    @Override
    public void update(Mail mail) {

    }
}
