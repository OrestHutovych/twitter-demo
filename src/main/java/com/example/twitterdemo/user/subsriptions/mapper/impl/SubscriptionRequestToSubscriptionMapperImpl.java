package com.example.twitterdemo.user.subsriptions.mapper.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.api.service.UserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.profile.service.UserProfileService;
import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import com.example.twitterdemo.user.subsriptions.entity.SubscriptionRequest;
import com.example.twitterdemo.user.subsriptions.mapper.SubscriptionRequestToSubscriptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionRequestToSubscriptionMapperImpl implements SubscriptionRequestToSubscriptionMapper {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final UserProfileApiService userProfileApiService;
    @Override
    public Subscription map(SubscriptionRequest source) {
        Subscription subscription = new Subscription();
        UserProfile owner = currentUserProfileApiService.currentUserProfile();
        UserProfile followProfile = userProfileApiService.findUserProfileById(source.followId());
        subscription.setFollower(owner);
        subscription.setFollowed(followProfile);
        return subscription;
    }
}
