package com.example.twitterdemo.user.profile.api.service.impl;

import com.example.twitterdemo.security.api.model.CurrentUserApiModel;
import com.example.twitterdemo.security.api.service.IdentityApiService;
import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserProfileApiServiceImpl implements CurrentUserProfileApiService {
    private final IdentityApiService identityApiService;
    private final UserProfileService userProfileService;
    @Override
    public UserProfile currentUserProfile() {
        CurrentUserApiModel currentUserApiModel = identityApiService
                .currentUserAccount()
                .orElseThrow(() -> new RuntimeException("User should be authentication to add tweet"));
        return userProfileService
                .findUserProfileById(currentUserApiModel.currenUserId())
                .orElseThrow(() -> new RuntimeException("User not found with this id. Try again"));
    }
}
