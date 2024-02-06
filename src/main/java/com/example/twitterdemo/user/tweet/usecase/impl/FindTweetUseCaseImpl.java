package com.example.twitterdemo.user.tweet.usecase.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.entity.TweetFindRequest;
import com.example.twitterdemo.user.tweet.entity.TweetResponse;
import com.example.twitterdemo.user.tweet.mapper.TweetToTweetResponseMapper;
import com.example.twitterdemo.user.tweet.service.TweetService;
import com.example.twitterdemo.user.tweet.usecase.FindTweetUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Collection;

@Configuration
@RequiredArgsConstructor
public class FindTweetUseCaseImpl implements FindTweetUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final TweetToTweetResponseMapper tweetToTweetResponseMapper;
    private final TweetService tweetService;

    @Override
    public Collection<TweetResponse> findTweets(TweetFindRequest findRequest) {
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();

        Sort sort = Sort.by(Sort.Direction.DESC, "createdTimestamp");
        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);

        Page<Tweet> allTweets = tweetService.findAllTweets(userProfile, pageable);
        return allTweets
                .stream()
                .map(tweetToTweetResponseMapper::map)
                .toList();
    }
}
