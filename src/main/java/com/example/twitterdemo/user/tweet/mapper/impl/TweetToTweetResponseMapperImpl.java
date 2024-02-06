package com.example.twitterdemo.user.tweet.mapper.impl;

import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.entity.response.TweetResponse;
import com.example.twitterdemo.user.tweet.mapper.TweetToTweetResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class TweetToTweetResponseMapperImpl implements TweetToTweetResponseMapper {
    @Override
    public TweetResponse map(Tweet source) {
        return new TweetResponse(source.getId(),source.getMessage(), source.getCreatedTimestamp());
    }
}
