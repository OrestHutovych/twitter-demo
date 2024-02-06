package com.example.twitterdemo.user.tweet.usecase;

import com.example.twitterdemo.user.tweet.entity.request.TweetEditRequest;
import com.example.twitterdemo.user.tweet.entity.response.TweetResponse;

public interface TweetEditUseCase {
    TweetResponse editTweet(TweetEditRequest request);
}
