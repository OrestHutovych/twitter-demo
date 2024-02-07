package com.example.twitterdemo.user.timeline.mapper.impl;

import com.example.twitterdemo.user.timeline.entity.response.TimelinePageResponse;
import com.example.twitterdemo.user.timeline.entity.response.TimelineResponse;
import com.example.twitterdemo.user.timeline.mapper.TweetPageToTimelinePageResponseMapper;
import com.example.twitterdemo.user.timeline.mapper.TweetToTimelineResponseMapper;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class TweetPageToTimelinePageResponseMapperImpl implements TweetPageToTimelinePageResponseMapper {
    private final TweetToTimelineResponseMapper mapper;
    @Override
    public TimelinePageResponse map(Page<Tweet> tweets) {
        Collection<TimelineResponse> timelineResponses = tweets
                .stream()
                .map(mapper::map)
                .toList();
        return new TimelinePageResponse(timelineResponses);
    }
}
