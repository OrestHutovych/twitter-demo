package com.example.twitterdemo.user.tweet.repository;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    Collection<Tweet> findAllByUserProfile(UserProfile userProfile);
}
