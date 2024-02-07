package com.example.twitterdemo.user.timeline.entity.response;

import java.time.Instant;

public record TimelineResponse(
        long id,
        long authorId,
        String message,
        String authorNickname,
        String authorImageLink,
        Instant createdTimestamp
) {
}
