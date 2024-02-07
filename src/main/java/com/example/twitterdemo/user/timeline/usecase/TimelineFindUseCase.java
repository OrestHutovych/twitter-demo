package com.example.twitterdemo.user.timeline.usecase;

import com.example.twitterdemo.user.timeline.entity.request.TimelineFindRequest;
import com.example.twitterdemo.user.timeline.entity.response.TimelinePageResponse;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@Validated
public interface TimelineFindUseCase {
    TimelinePageResponse findTimeline(@Valid TimelineFindRequest findRequest);
}
