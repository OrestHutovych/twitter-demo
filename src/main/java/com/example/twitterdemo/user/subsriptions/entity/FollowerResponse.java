package com.example.twitterdemo.user.subsriptions.entity;

import java.time.Instant;

public record FollowerResponse(
        long subscriptionId,
        long followerId,
        String followerNickname,
        String followerImageLink,
        Instant createdTimestamp
) {
}
