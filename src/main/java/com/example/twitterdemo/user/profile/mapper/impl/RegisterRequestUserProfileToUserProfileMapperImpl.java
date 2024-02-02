package com.example.twitterdemo.user.profile.mapper.impl;


import com.example.twitterdemo.security.api.model.CurrentUserApiModel;
import com.example.twitterdemo.security.api.service.IdentityApiService;
import com.example.twitterdemo.user.profile.entity.RegisterRequestUserProfile;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.profile.mapper.RegisterRequestUserProfileToUserProfileMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterRequestUserProfileToUserProfileMapperImpl implements RegisterRequestUserProfileToUserProfileMapper {
    private final IdentityApiService identityApiService;

    public RegisterRequestUserProfileToUserProfileMapperImpl(IdentityApiService identityApiService) {
        this.identityApiService = identityApiService;
    }

    @Override
    public UserProfile map(RegisterRequestUserProfile source) {

        CurrentUserApiModel currentUserApiModel = identityApiService.currentUserAccount()
                .orElseThrow(() -> new RuntimeException("You need login to create user profile"));

        UserProfile userProfile = new UserProfile();
        userProfile.setId(currentUserApiModel.currenUserId());
        userProfile.setNickname(source.nickname());
        userProfile.setImageLink(source.imageLink());

        return userProfile;
    }
}
