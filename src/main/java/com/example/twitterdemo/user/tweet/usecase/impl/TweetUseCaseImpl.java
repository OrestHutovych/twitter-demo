package com.example.twitterdemo.user.tweet.usecase.impl;

import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.entity.TweetAddRequest;
import com.example.twitterdemo.user.tweet.entity.TweetResponse;
import com.example.twitterdemo.user.tweet.mapper.TweetAddRequestToTweetMapper;
import com.example.twitterdemo.user.tweet.mapper.TweetToTweetResponseMapper;
import com.example.twitterdemo.user.tweet.service.TweetService;
import com.example.twitterdemo.user.tweet.usecase.TweetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetUseCaseImpl implements TweetUseCase {
    private final TweetAddRequestToTweetMapper tweetAddRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;
    @Override
    public TweetResponse addTweet(TweetAddRequest request) {
        Tweet mappedTweet = tweetAddRequestToTweetMapper.map(request);
        Tweet tweet = tweetService.createTweet(mappedTweet);
        return tweetToTweetResponseMapper.map(tweet);
    }
}
