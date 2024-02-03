package com.example.twitterdemo.user.tweet.service.impl;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import com.example.twitterdemo.user.tweet.repository.TweetRepository;
import com.example.twitterdemo.user.tweet.service.TweetService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class TweetServiceImpl implements TweetService {
    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet createTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }

    @Override
    public Tweet editTweet(Tweet tweet) {
        return tweetRepository.save(tweet);
    }
    @Override
    public Optional<Tweet> findTweetById(long tweetId) {
        return tweetRepository.findById(tweetId);
    }

    @Override
    public Collection<Tweet> findAllTweets(UserProfile userProfile) {
        return tweetRepository.findAllByUserProfile(userProfile);
    }

    @Override
    public void deleteTweet(long tweetId) {
        tweetRepository.deleteById(tweetId);
    }
}
