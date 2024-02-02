package com.example.twitterdemo.user.tweet.usecase.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.service.TweetService;
import com.example.twitterdemo.user.tweet.usecase.TweetDeleteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetDeleteUseCaseImpl implements TweetDeleteUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    @Override
    public void deleteTweet(long tweetId) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        String errorMessage = String.format("Tweet not found by id: %s", tweetId);

        UserProfile owner = tweetService
                .findTweetById(tweetId)
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> new RuntimeException(errorMessage));

        if(!actor.equals(owner)){
            throw new RuntimeException("Something went wrong and you can not delete this tweet. Try again");
        }
        tweetService.deleteTweet(tweetId);
    }
}
