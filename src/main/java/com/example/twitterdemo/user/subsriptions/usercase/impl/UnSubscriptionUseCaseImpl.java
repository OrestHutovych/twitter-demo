package com.example.twitterdemo.user.subsriptions.usercase.impl;

import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import com.example.twitterdemo.user.subsriptions.entity.request.UnSubscriptionRequest;
import com.example.twitterdemo.user.subsriptions.mapper.UnSubscriptionRequestToSubscriptionMapper;
import com.example.twitterdemo.user.subsriptions.service.SubscriptionService;
import com.example.twitterdemo.user.subsriptions.usercase.UnSubscriptionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UnSubscriptionUseCaseImpl implements UnSubscriptionUseCase {
    private final UnSubscriptionRequestToSubscriptionMapper unSubscriptionRequestToSubscriptionMapper;
    private final SubscriptionService subscriptionService;
    @Override
    public void unsubscription(UnSubscriptionRequest request) {
        Subscription mappedRequest = unSubscriptionRequestToSubscriptionMapper.map(request);
        if(mappedRequest.getFollowed().equals(mappedRequest.getFollower())) {
            throw new RuntimeException("You can not unsubscribe on yourself");
        }
        if(!subscriptionService.existsSubscription(mappedRequest)){
            String errorMessage = String.format("You are not subscribe to this user profile: %s", mappedRequest.getFollower().getNickname());
            throw new RuntimeException(errorMessage);
        }
        subscriptionService.unsubscribe(mappedRequest);
    }
}
