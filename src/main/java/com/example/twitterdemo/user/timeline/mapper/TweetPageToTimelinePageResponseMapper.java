package com.example.twitterdemo.user.timeline.mapper;

import com.example.twitterdemo.user.profile.mapper.Mapper;
import com.example.twitterdemo.user.timeline.entity.response.TimelinePageResponse;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import org.springframework.data.domain.Page;

public interface TweetPageToTimelinePageResponseMapper extends Mapper<TimelinePageResponse, Page<Tweet>> {
}
