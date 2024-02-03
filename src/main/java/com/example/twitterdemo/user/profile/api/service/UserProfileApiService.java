package com.example.twitterdemo.user.profile.api.service;

import com.example.twitterdemo.user.profile.entity.UserProfile;

public interface UserProfileApiService {
    UserProfile findUserProfileById(long id);
}
