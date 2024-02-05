package com.example.twitterdemo.user.subsriptions.controller;

import com.example.twitterdemo.user.subsriptions.entity.FollowerResponse;
import com.example.twitterdemo.user.subsriptions.entity.SubscriptionRequest;
import com.example.twitterdemo.user.subsriptions.entity.UnSubscriptionRequest;
import com.example.twitterdemo.user.subsriptions.usercase.SubscriptionFindFollowersUseCase;
import com.example.twitterdemo.user.subsriptions.usercase.SubscriptionUseCase;
import com.example.twitterdemo.user.subsriptions.usercase.UnSubscriptionUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
    public Collection<FollowerResponse> getFollowers(){
        return subscriptionFindFollowersUseCase.getFollowers();
    }
}
