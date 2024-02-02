package com.example.twitterdemo.user.tweet.usecase;

import com.example.twitterdemo.user.tweet.entity.TweetAddRequest;
import com.example.twitterdemo.user.tweet.entity.TweetResponse;

public interface TweetUseCase {
    TweetResponse addTweet(TweetAddRequest request);
}
