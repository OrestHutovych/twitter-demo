package com.example.twitterdemo.security.api.service.impl;

import com.example.twitterdemo.security.api.model.CurrentUserApiModel;
import com.example.twitterdemo.security.api.service.IdentityApiService;
import com.example.twitterdemo.security.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdentityApiServiceImpl implements IdentityApiService {
    private final UserAccountService userAccountService;
    @Override
    public Optional<CurrentUserApiModel> currentUserAccount() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        if(authentication == null){
            return Optional.empty();
        }

        String username = authentication.getName();
        return userAccountService
                .findUserByUsername(username)
                .map(userAccount -> new CurrentUserApiModel(userAccount.getId()));
    }
}
