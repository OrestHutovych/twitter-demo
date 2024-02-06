package com.example.twitterdemo.user.tweet.mapper.impl;

import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.entity.request.TweetEditRequest;
import com.example.twitterdemo.user.tweet.mapper.TweetEditRequestToTweetMapper;
import com.example.twitterdemo.user.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetEditRequestToTweetMapperImpl implements TweetEditRequestToTweetMapper {
    private final TweetService tweetService;
    @Override
    public Tweet map(TweetEditRequest source) {
        Tweet currentTweet = tweetService
                .findTweetById(source.id())
                .orElseThrow(() -> new RuntimeException("Tweet not found!"));
        currentTweet.setMessage(source.message());
        return currentTweet;
    }
}
