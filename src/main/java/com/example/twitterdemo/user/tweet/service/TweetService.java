package com.example.twitterdemo.user.tweet.service;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.entity.Tweet;

import java.util.Collection;
import java.util.Optional;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
    Tweet editTweet(Tweet tweet);
    Optional<Tweet> findTweetById(long tweetId);
    Collection<Tweet> findAllTweets(UserProfile userProfile);
    void deleteTweet(long tweetId);
}
