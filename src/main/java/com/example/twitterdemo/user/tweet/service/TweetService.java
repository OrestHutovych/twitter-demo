package com.example.twitterdemo.user.tweet.service;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TweetService {
    Tweet createTweet(Tweet tweet);
    Tweet editTweet(Tweet tweet);
    Optional<Tweet> findTweetById(long tweetId);
    Page<Tweet> findAllTweets(UserProfile userProfile, Pageable pageable);
    Page<Tweet> findAllFollowersTweets(UserProfile userProfile, Pageable pageable);
    void deleteTweet(long tweetId);
}
