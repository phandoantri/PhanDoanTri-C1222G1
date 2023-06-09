package com.example.ss13_authentication.repository;

import com.example.ss13_authentication.entity.AppUser;
import com.example.ss13_authentication.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findUserRolesByAppUser(AppUser appUser);
}
