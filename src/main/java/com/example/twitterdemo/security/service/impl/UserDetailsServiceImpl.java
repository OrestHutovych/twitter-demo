package com.example.twitterdemo.security.service.impl;

import com.example.twitterdemo.security.service.UserAccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserAccountService userAccountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountService
                .findUserByUsername(username)
                .map(userAccount -> new User(
                        userAccount.getUsername(),
                        userAccount.getPassword(),
                        userAccount.getAuthorities()
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
