package com.example.twitterdemo.user.tweet.usecase;

import com.example.twitterdemo.user.tweet.entity.TweetResponse;

import java.util.Collection;

public interface FindTweetUseCase {
    Collection<TweetResponse> findTweets();
}
