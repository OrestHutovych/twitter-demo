package com.example.twitterdemo.user.profile.api.service.impl;

import com.example.twitterdemo.user.profile.api.service.UserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.profile.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProfileApiServiceImpl implements UserProfileApiService {
    private final UserProfileRepository userProfileRepository;
    @Override
    public UserProfile findUserProfileById(long id) {
        String errorMessage = String.format("User profile not found by this id: %s", id);
        return userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException(errorMessage));
    }
}
