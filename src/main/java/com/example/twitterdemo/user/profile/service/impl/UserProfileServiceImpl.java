package com.example.twitterdemo.user.profile.service.impl;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.profile.repository.UserProfileRepository;
import com.example.twitterdemo.user.profile.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    @Override
    public void createUserProfile(UserProfile userProfile) {
        if(userProfileRepository.existsById(userProfile.getId())) throw new RuntimeException("This id already exist.");
        if(userProfileRepository.existsByNickname(userProfile.getNickname())) throw new RuntimeException("This nickname already exist.");
        userProfileRepository.save(userProfile);
    }

    @Override
    public Optional<UserProfile> findUserProfileById(long id) {
        return userProfileRepository.findById(id);
    }
}
