package com.example.twitterdemo.user.timeline.mapper;

import com.example.twitterdemo.user.profile.mapper.Mapper;
import com.example.twitterdemo.user.timeline.entity.response.TimelineResponse;
import com.example.twitterdemo.user.tweet.entity.Tweet;

public interface TweetToTimelineResponseMapper extends Mapper<TimelineResponse, Tweet> {
}
