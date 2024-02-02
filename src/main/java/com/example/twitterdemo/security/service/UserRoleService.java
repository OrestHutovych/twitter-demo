package com.example.twitterdemo.security.service;

import com.example.twitterdemo.security.entity.UserRole;

import java.util.Optional;

public interface UserRoleService {
    Optional<UserRole> findUserRole(String role);
}
