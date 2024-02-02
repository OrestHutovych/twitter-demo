package com.example.twitterdemo.user.tweet.service.impl;

import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.repository.TweetRepository;
import com.example.twitterdemo.user.tweet.service.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
    private final TweetRepository tweetRepository;
    @Override
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }
}
