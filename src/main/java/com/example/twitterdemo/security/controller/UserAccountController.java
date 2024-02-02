package com.example.twitterdemo.security.controller;

import com.example.twitterdemo.security.entity.RegisterRequest;
import com.example.twitterdemo.security.entity.UserAccount;
import com.example.twitterdemo.security.mapper.RegisterRequestToUserAccountMapper;
import com.example.twitterdemo.security.service.UserAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class UserAccountController {
    private final RegisterRequestToUserAccountMapper mapper;
    private final UserAccountService userAccountService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterRequest request){
        UserAccount userAccount = mapper.map(request);
        userAccountService.createUserAccount(userAccount);
    }
}
