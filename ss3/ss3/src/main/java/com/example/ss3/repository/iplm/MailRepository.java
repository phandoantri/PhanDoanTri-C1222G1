package com.example.ss3.repository.iplm;

import com.example.ss3.model.Mail;
import com.example.ss3.repository.IMailRepository;
import com.example.ss3.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class MailRepository implements IMailRepository {
    private static List<Mail> mailList=new ArrayList<>();
    private static List<String> languageList=new ArrayList<>();
    private static List<Integer> pageSize=new ArrayList<>();
    static {
        mailList.add(new Mail(1,"English",25,true,"King"));
        languageList.add("English");
        languageList.add("Japanese");
        languageList.add("VietNamese");
        languageList.add("Chinese");
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);
    }

    @Override
    public List<Mail> getAll() {
        return mailList;
    }

    @Override
    public void update(Mail mail) {

    }

    @Override
    public List<String> getAllLanguage() {
        return languageList;
    }

    @Override
    public List<Integer> getPageSize() {
        return pageSize;
    }
}
