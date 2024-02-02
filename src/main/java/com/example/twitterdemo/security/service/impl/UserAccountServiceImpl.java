package com.example.twitterdemo.security.service.impl;

import com.example.twitterdemo.security.entity.UserAccount;
import com.example.twitterdemo.security.repository.UserAccountRepository;
import com.example.twitterdemo.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {
    private final UserAccountRepository accountRepository;
    @Override
    public void createUserAccount(UserAccount userAccount) {
        boolean existByUsername = accountRepository.existsByUsername(userAccount.getUsername());

        if(existByUsername){
            throw new RuntimeException("This username already exist! Try again");
        }
        accountRepository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> findUserByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
