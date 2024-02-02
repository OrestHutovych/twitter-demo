package com.example.twitterdemo.security.mapper.impl;

import com.example.twitterdemo.security.entity.RegisterRequest;
import com.example.twitterdemo.security.entity.UserAccount;
import com.example.twitterdemo.security.entity.UserRole;
import com.example.twitterdemo.security.mapper.RegisterRequestToUserAccountMapper;
import com.example.twitterdemo.security.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Locale;
import java.util.Set;
@RequiredArgsConstructor
@Configuration
public class RegisterRequestToUserAccountMapperImpl implements RegisterRequestToUserAccountMapper {
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService userRoleService;

    @Override
    public UserAccount map(RegisterRequest request) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(request.username().toLowerCase(Locale.ROOT));
        userAccount.setPassword(passwordEncoder.encode(request.password()));
        UserRole userRole = userRoleService.findUserRole("ROLE_USER").orElseThrow(() -> new RuntimeException("User role was not found"));
        userAccount.setAuthorities(Set.of(userRole));
        return userAccount;
    }
}
