package com.example.ss13_authentication.repository;

import com.example.ss13_authentication.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String name);
}
