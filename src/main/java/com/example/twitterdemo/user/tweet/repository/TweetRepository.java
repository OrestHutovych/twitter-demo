package com.example.twitterdemo.user.tweet.repository;

import com.example.twitterdemo.user.tweet.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
