package com.example.twitterdemo.user.tweet.usecase.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.entity.request.TweetEditRequest;
import com.example.twitterdemo.user.tweet.entity.response.TweetResponse;
import com.example.twitterdemo.user.tweet.mapper.TweetEditRequestToTweetMapper;
import com.example.twitterdemo.user.tweet.mapper.TweetToTweetResponseMapper;
import com.example.twitterdemo.user.tweet.service.TweetService;
import com.example.twitterdemo.user.tweet.usecase.TweetEditUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TweetEditUseCaseImpl implements TweetEditUseCase {
    private final TweetEditRequestToTweetMapper tweetEditRequestToTweetMapper;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetService tweetService;
    @Override
    public TweetResponse editTweet(TweetEditRequest request) {
        UserProfile actor = currentUserProfileApiService.currentUserProfile();
        String errorMessage = String.format("Tweet not found by id: %s. Write correct id", request.id());
        UserProfile owner = tweetService.findTweetById(request.id())
                .map(Tweet::getUserProfile)
                .orElseThrow(() -> new RuntimeException(errorMessage));
        if(!actor.equals(owner)){
            throw new RuntimeException("Something went wrong and you can not edit this tweet. Try again");
        }
        Tweet mappedTweet = tweetEditRequestToTweetMapper.map(request);
        Tweet tweet = tweetService.editTweet(mappedTweet);
        return tweetToTweetResponseMapper.map(tweet);
    }
}
