package com.example.twitterdemo.user.subsriptions.service;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;

public interface SubscriptionService {
    void subscribe(Subscription subscription);
    void unsubscribe(Subscription subscription);
    boolean existsSubscription(Subscription subscription);
    Page<Subscription> findAllFollowerByUserProfile(UserProfile userProfile, Pageable pageable);
}
