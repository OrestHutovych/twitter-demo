package com.example.twitterdemo.user.subsriptions.usercase.impl;

import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import com.example.twitterdemo.user.subsriptions.entity.request.SubscriptionRequest;
import com.example.twitterdemo.user.subsriptions.mapper.SubscriptionRequestToSubscriptionMapper;
import com.example.twitterdemo.user.subsriptions.service.SubscriptionService;
import com.example.twitterdemo.user.subsriptions.usercase.SubscriptionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscriptionUserCaseImpl implements SubscriptionUseCase {
    private final SubscriptionRequestToSubscriptionMapper subscriptionRequestToSubscriptionMapper;
    private final SubscriptionService subscriptionService;
    @Override
    public void subscribe(SubscriptionRequest request) {
        Subscription subscription = subscriptionRequestToSubscriptionMapper.map(request);
        if(subscription.getFollowed().equals(subscription.getFollower())) {
            throw new RuntimeException("You can not subscribe on yourself");
        }
        if(subscriptionService.existsSubscription(subscription)){
            String messageError = String.format("You already subscribe to this user profile: %s", subscription.getFollowed().getNickname());
            throw new RuntimeException(messageError);
        }
        subscriptionService.subscribe(subscription);
    }
}
