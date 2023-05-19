package com.example.ss13_authentication_authorization.entity;

import javax.persistence.*;

@Entity
@Table(name = "app_role",uniqueConstraints = {
        @UniqueConstraint(name = "APP_ROLE_UK", columnNames = "role_name")})

public class AppRole {
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private int roleId;
    private String roleName;

    public AppRole() {
    }

    public AppRole(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
