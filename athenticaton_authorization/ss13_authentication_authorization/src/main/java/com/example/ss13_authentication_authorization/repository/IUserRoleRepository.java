package com.example.ss13_authentication_authorization.repository;

import com.example.ss13_authentication_authorization.entity.AppUser;
import com.example.ss13_authentication_authorization.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findByAppUser(AppUser appUser);

    List<UserRole> getRoleNames(AppUser appUser);
}
