package com.example.twitterdemo.user.subsriptions.usercase;

import com.example.twitterdemo.user.subsriptions.entity.FollowerResponse;

import java.util.Collection;

public interface SubscriptionFindFollowersUseCase {
    Collection<FollowerResponse> getFollowers();
}
