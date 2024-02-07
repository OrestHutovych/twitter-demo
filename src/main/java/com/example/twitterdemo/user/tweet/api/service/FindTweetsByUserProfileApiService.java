package com.example.twitterdemo.user.tweet.api.service;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface FindTweetsByUserProfileApiService {
    Page<Tweet> findAllFollowersTweet(UserProfile userProfile, Pageable pageable);
}
