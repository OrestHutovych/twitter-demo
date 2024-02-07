package com.example.twitterdemo.user.timeline.entity.response;

import java.util.Collection;

public record TimelinePageResponse(
        Collection<TimelineResponse> tweets
) {
}
