package com.example.twitterdemo.user.subsriptions.usercase.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.subsriptions.entity.FollowerResponse;
import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import com.example.twitterdemo.user.subsriptions.service.SubscriptionService;
import com.example.twitterdemo.user.subsriptions.usercase.SubscriptionFindFollowersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class SubscriptionFindFollowersUseCaseImpl implements SubscriptionFindFollowersUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final SubscriptionService subscriptionService;
    @Override
    public Collection<FollowerResponse> getFollowers() {
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();
        Collection<Subscription> subscriptions = subscriptionService.findAllFollowerByUserProfile(userProfile);
        return subscriptions
                .stream()
                .map(item -> new FollowerResponse(
                        item.getId(),
                        item.getFollower().getId(),
                        item.getFollower().getNickname(),
                        item.getFollower().getImageLink(),
                        item.getCreatedTimestamp())
                ).toList();
    }
}
