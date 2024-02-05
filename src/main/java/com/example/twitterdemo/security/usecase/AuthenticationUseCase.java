package com.example.twitterdemo.security.usecase;

import com.example.twitterdemo.security.entity.LoginRequest;
import com.example.twitterdemo.security.entity.AccessToken;

public interface AuthenticationUseCase {
    AccessToken authenticate(LoginRequest request);
}
