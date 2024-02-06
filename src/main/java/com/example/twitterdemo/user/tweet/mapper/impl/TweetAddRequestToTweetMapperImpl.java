package com.example.twitterdemo.user.tweet.mapper.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.entity.request.TweetAddRequest;
import com.example.twitterdemo.user.tweet.mapper.TweetAddRequestToTweetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TweetAddRequestToTweetMapperImpl implements TweetAddRequestToTweetMapper {

    private final CurrentUserProfileApiService currentUserProfileApiService;

    @Override
    public Tweet map(TweetAddRequest source) {
        Tweet tweet = new Tweet();
        tweet.setMessage(source.message());
        tweet.setUserProfile(currentUserProfileApiService.currentUserProfile());
        return tweet;
    }
}
