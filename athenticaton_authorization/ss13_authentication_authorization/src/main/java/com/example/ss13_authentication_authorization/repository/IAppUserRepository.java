package com.example.ss13_authentication_authorization.repository;

import com.example.ss13_authentication_authorization.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByNameUser(String name);
}
