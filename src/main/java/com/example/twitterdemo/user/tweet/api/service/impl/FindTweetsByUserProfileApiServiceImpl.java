package com.example.twitterdemo.user.tweet.api.service.impl;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.api.service.FindTweetsByUserProfileApiService;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindTweetsByUserProfileApiServiceImpl implements FindTweetsByUserProfileApiService {
    private final TweetService tweetService;
    @Override
    public Page<Tweet> findAllFollowersTweet(UserProfile userProfile, Pageable pageable) {
        return tweetService.findAllFollowersTweets(userProfile, pageable);
    }
}
