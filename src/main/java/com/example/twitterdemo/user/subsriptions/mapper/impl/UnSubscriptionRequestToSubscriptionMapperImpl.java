package com.example.twitterdemo.user.subsriptions.mapper.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.api.service.UserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import com.example.twitterdemo.user.subsriptions.entity.UnSubscriptionRequest;
import com.example.twitterdemo.user.subsriptions.mapper.UnSubscriptionRequestToSubscriptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnSubscriptionRequestToSubscriptionMapperImpl implements UnSubscriptionRequestToSubscriptionMapper {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final UserProfileApiService userProfileApiService;
    @Override
    public Subscription map(UnSubscriptionRequest source) {
        Subscription subscription = new Subscription();
        UserProfile owner = currentUserProfileApiService.currentUserProfile();
        UserProfile followedProfile = userProfileApiService.findUserProfileById(source.followedId());
        subscription.setFollower(owner);
        subscription.setFollowed(followedProfile);
        return subscription;
    }
}
