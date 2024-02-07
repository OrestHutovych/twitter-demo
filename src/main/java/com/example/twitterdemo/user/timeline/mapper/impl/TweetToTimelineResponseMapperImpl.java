package com.example.twitterdemo.user.timeline.mapper.impl;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.timeline.entity.response.TimelineResponse;
import com.example.twitterdemo.user.timeline.mapper.TweetToTimelineResponseMapper;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import org.springframework.stereotype.Component;

@Component
public class TweetToTimelineResponseMapperImpl implements TweetToTimelineResponseMapper {
    @Override
    public TimelineResponse map(Tweet source) {
        UserProfile userProfile = source.getUserProfile();
        return new TimelineResponse(
                source.getId(),
                userProfile.getId(),
                source.getMessage(),
                userProfile.getNickname(),
                userProfile.getImageLink(),
                source.getCreatedTimestamp()
        );
    }
}
