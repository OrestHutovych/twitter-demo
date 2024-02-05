package com.example.twitterdemo.user.subsriptions.service;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.subsriptions.entity.Subscription;

import java.util.Collection;

public interface SubscriptionService {
    void subscribe(Subscription subscription);
    void unsubscribe(Subscription subscription);
    boolean existsSubscription(Subscription subscription);
    Collection<Subscription> findAllFollowerByUserProfile(UserProfile userProfile);
}
