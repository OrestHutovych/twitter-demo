package com.example.twitterdemo.user.tweet.usecase;

import com.example.twitterdemo.user.tweet.entity.request.TweetFindRequest;
import com.example.twitterdemo.user.tweet.entity.request.TweetPageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface FindTweetUseCase {
    TweetPageResponse findTweets(@Valid TweetFindRequest findRequest);
}
