package com.example.twitterdemo.security.api.service;

import com.example.twitterdemo.security.api.model.CurrentUserApiModel;

import java.util.Optional;

public interface IdentityApiService {
    Optional<CurrentUserApiModel> currentUserAccount();
}
