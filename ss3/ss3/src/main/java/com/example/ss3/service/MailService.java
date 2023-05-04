package com.example.ss3.service;

import com.example.ss3.model.Mail;
import com.example.ss3.repository.IMailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService{
    @Autowired
    private IMailRepository iMailRepository;

    @Override
    public List<Mail> getAll() {
        List<Mail> mailList=iMailRepository.getAll();
        for (int i=0;i<mailList.size();i++){
            System.out.println(mailList.get(i));
        }
        return mailList;
    }

    @Override
    public void update(Mail mail) {
        iMailRepository.update(mail);
    }
}
