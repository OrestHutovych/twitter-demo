package com.example.twitterdemo.security.controller;

import com.example.twitterdemo.security.entity.LoginRequest;
import com.example.twitterdemo.security.entity.AccessToken;
import com.example.twitterdemo.security.usecase.AuthenticationUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authentication")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationUseCase authenticationUseCase;
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AccessToken login(@Valid @RequestBody LoginRequest loginRequest){
        return authenticationUseCase.authenticate(loginRequest);
    }
}
