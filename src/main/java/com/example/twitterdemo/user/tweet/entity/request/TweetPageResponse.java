package com.example.twitterdemo.user.tweet.entity.request;

import com.example.twitterdemo.user.tweet.entity.response.TweetResponse;

import java.util.Collection;

public record TweetPageResponse(Collection<TweetResponse> tweets) {
}
