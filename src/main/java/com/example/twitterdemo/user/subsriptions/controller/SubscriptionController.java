package com.example.twitterdemo.user.subsriptions.controller;

import com.example.twitterdemo.user.subsriptions.entity.request.TweetFindRequest;
import com.example.twitterdemo.user.subsriptions.entity.response.FollowerPageResponse;
import com.example.twitterdemo.user.subsriptions.entity.request.SubscriptionRequest;
import com.example.twitterdemo.user.subsriptions.entity.request.UnSubscriptionRequest;
import com.example.twitterdemo.user.subsriptions.usercase.SubscriptionFindFollowersUseCase;
import com.example.twitterdemo.user.subsriptions.usercase.SubscriptionUseCase;
import com.example.twitterdemo.user.subsriptions.usercase.UnSubscriptionUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionUseCase subscriptionUseCase;
    private final UnSubscriptionUseCase unSubscriptionUseCase;
    private final SubscriptionFindFollowersUseCase subscriptionFindFollowersUseCase;

    @PostMapping("/subscribe")
    public void subscribe(@Valid @RequestBody SubscriptionRequest request){
        subscriptionUseCase.subscribe(request);
    }

    @DeleteMapping("/unsubscribe")
    public void unsubscription(@Valid @RequestBody UnSubscriptionRequest request){
        unSubscriptionUseCase.unsubscription(request);
    }
    @GetMapping("/followers")
    public FollowerPageResponse getFollowers(@RequestParam(name = "page") int page,
                                             @RequestParam(name = "limit") int limit){
        TweetFindRequest tweetFindRequest = new TweetFindRequest(page,limit);
        return subscriptionFindFollowersUseCase.getFollowers(tweetFindRequest);
    }
}
