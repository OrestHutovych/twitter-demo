package com.example.twitterdemo.user.profile.controller;

import com.example.twitterdemo.user.profile.entity.RegisterRequestUserProfile;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.profile.mapper.RegisterRequestUserProfileToUserProfileMapper;
import com.example.twitterdemo.user.profile.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/user_profile")
@RequiredArgsConstructor
public class UserProfileController {

    private final RegisterRequestUserProfileToUserProfileMapper mapper;
    private final UserProfileService userProfileService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUserProfile(@Valid @RequestBody RegisterRequestUserProfile userProfile){
        UserProfile userProfileComp = mapper.map(userProfile);
        userProfileService.createUserProfile(userProfileComp);
    }
}
