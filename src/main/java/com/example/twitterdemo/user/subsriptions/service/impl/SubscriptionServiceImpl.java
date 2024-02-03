package com.example.twitterdemo.user.subsriptions.service.impl;

import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import com.example.twitterdemo.user.subsriptions.repository.SubscriptionRepository;
import com.example.twitterdemo.user.subsriptions.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    @Override
    public void subscribe(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }
    @Override
    public void unsubscribe(Subscription subscription) {
        Subscription owner = subscriptionRepository
                .findByFollowerAndFollowed(subscription.getFollower(), subscription.getFollowed())
                .orElseThrow(() -> new RuntimeException("Not found"));
        subscriptionRepository.delete(owner);
    }
    @Override
    public boolean existsSubscription(Subscription subscription) {
        return subscriptionRepository.existsByFollowerAndFollowed(subscription.getFollower(),subscription.getFollowed());
    }
}