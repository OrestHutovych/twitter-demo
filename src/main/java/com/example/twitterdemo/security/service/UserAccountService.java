package com.example.twitterdemo.security.service;

import com.example.twitterdemo.security.entity.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserAccountService {
    void createUserAccount(UserAccount userAccount);
    Optional<UserAccount> findUserByUsername(String username);
}
