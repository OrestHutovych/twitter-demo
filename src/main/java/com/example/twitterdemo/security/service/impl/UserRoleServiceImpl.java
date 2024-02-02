package com.example.twitterdemo.security.service.impl;

import com.example.twitterdemo.security.entity.UserRole;
import com.example.twitterdemo.security.repository.UserRoleRepository;
import com.example.twitterdemo.security.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;
    @Override
    public Optional<UserRole> findUserRole(String role) {
        return userRoleRepository.findByAuthority(role);
    }
}
