package com.example.twitterdemo.security.usecase.impl;

import com.example.twitterdemo.security.entity.LoginRequest;
import com.example.twitterdemo.security.entity.AccessToken;
import com.example.twitterdemo.security.service.AccessTokenService;
import com.example.twitterdemo.security.usecase.AuthenticationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {
    private final AuthenticationManager authenticationManager;
    private final AccessTokenService accessTokenService;
    @Override
    public AccessToken authenticate(LoginRequest request) {
        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(
            request.username(),
            request.password()
        );
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String idToken = accessTokenService.generateIdToken(authenticate);
        return new AccessToken(idToken);
    }
}
