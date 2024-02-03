package com.example.twitterdemo.user.subsriptions.service;

import com.example.twitterdemo.user.subsriptions.entity.Subscription;

public interface SubscriptionService {
    void subscribe(Subscription subscription);
    void unsubscribe(Subscription subscription);
    boolean existsSubscription(Subscription subscription);
}
