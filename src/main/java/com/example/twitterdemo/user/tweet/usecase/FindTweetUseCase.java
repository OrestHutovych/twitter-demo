package com.example.twitterdemo.user.tweet.usecase;

import com.example.twitterdemo.user.tweet.entity.TweetFindRequest;
import com.example.twitterdemo.user.tweet.entity.TweetResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Collection;
@Validated
public interface FindTweetUseCase {
    Collection<TweetResponse> findTweets(@Valid TweetFindRequest findRequest);
}
