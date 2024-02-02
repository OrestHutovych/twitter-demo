package com.example.twitterdemo.user.tweet.usecase;

import com.example.twitterdemo.user.tweet.entity.TweetEditRequest;
import com.example.twitterdemo.user.tweet.entity.TweetResponse;

public interface TweetEditUseCase {
    TweetResponse editTweet(TweetEditRequest request);
}
