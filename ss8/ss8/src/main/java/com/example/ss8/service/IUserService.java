package com.example.ss8.service;

import com.example.ss8.model.User;
import com.example.ss8.modelDTO.UserDTO;

import java.util.List;

public interface IUserService {

    List<User> getAll();
    void save(User user);
}
