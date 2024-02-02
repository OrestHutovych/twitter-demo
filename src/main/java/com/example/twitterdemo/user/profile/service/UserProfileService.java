package com.example.twitterdemo.user.profile.service;

import com.example.twitterdemo.user.profile.entity.UserProfile;

import java.util.Optional;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);
    Optional<UserProfile> findUserProfileById(long id);
}
