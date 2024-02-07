package com.example.twitterdemo.user.subsriptions.usercase;

import com.example.twitterdemo.user.subsriptions.entity.request.TweetFindRequest;
import com.example.twitterdemo.user.subsriptions.entity.response.FollowerPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;


@Validated
public interface SubscriptionFindFollowersUseCase {
    FollowerPageResponse getFollowers(@Valid TweetFindRequest tweetFindRequest);
}
