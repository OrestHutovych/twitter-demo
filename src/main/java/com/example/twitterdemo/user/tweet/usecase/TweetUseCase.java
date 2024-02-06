package com.example.twitterdemo.user.tweet.usecase;

import com.example.twitterdemo.user.tweet.entity.request.TweetAddRequest;
import com.example.twitterdemo.user.tweet.entity.response.TweetResponse;

public interface TweetUseCase {
    TweetResponse addTweet(TweetAddRequest request);
}
