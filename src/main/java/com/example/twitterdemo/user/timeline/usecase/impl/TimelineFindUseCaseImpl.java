package com.example.twitterdemo.user.timeline.usecase.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.timeline.entity.request.TimelineFindRequest;
import com.example.twitterdemo.user.timeline.entity.response.TimelinePageResponse;
import com.example.twitterdemo.user.timeline.mapper.TweetPageToTimelinePageResponseMapper;
import com.example.twitterdemo.user.timeline.usecase.TimelineFindUseCase;
import com.example.twitterdemo.user.tweet.api.service.FindTweetsByUserProfileApiService;
import com.example.twitterdemo.user.tweet.entity.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TimelineFindUseCaseImpl implements TimelineFindUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final FindTweetsByUserProfileApiService tweetsApiService;
    private final TweetPageToTimelinePageResponseMapper mapper;
    @Override
    public TimelinePageResponse findTimeline(TimelineFindRequest findRequest) {
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();

        Sort sort = Sort.by(Sort.Direction.DESC, "createdTimestamp");
        Pageable pageable = PageRequest.of(findRequest.page(), findRequest.limit(), sort);
        Page<Tweet> tweets = tweetsApiService.findAllFollowersTweet(userProfile, pageable);
        return mapper.map(tweets);
    }
}
