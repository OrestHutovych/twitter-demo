package com.example.twitterdemo.user.tweet.service;

import com.example.twitterdemo.user.tweet.entity.Tweet;

import java.util.Optional;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
    Tweet editTweet(Tweet tweet);
    Optional<Tweet> findTweetById(long tweetId);
    void deleteTweet(long tweetId);
}
