package com.example.twitterdemo.user.timeline.controller;

import com.example.twitterdemo.user.timeline.entity.request.TimelineFindRequest;
import com.example.twitterdemo.user.timeline.entity.response.TimelinePageResponse;
import com.example.twitterdemo.user.timeline.usecase.TimelineFindUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/timeline")
@RequiredArgsConstructor
public class TimelineController {
    private final TimelineFindUseCase timelineFindUseCase;
    @GetMapping
    private TimelinePageResponse findTimeline(@RequestParam(name = "page") int page,
                                              @RequestParam(name = "limit") int limit){
        TimelineFindRequest findRequest = new TimelineFindRequest(page, limit);
        return timelineFindUseCase.findTimeline(findRequest);
    }
}
