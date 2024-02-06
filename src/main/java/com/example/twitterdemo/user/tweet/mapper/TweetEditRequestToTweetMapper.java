package com.example.twitterdemo.user.tweet.mapper;

import com.example.twitterdemo.security.mapper.Mapper;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.entity.request.TweetEditRequest;

public interface TweetEditRequestToTweetMapper extends Mapper<Tweet, TweetEditRequest> {
}
