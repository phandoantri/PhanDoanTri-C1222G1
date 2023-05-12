package com.example.ss8.service.impl;

import com.example.ss8.model.User;
import com.example.ss8.repository.IUserRepository;
import com.example.ss8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
@Autowired
private IUserRepository iUserRepository;

    @Override
    public List<User> getAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
