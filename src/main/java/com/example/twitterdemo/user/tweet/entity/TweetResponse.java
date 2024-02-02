package com.example.twitterdemo.user.tweet.entity;

import java.time.Instant;

public record TweetResponse(long id, String message, Instant createdTimestamp) {
}
