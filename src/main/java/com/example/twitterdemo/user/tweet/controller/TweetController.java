package com.example.twitterdemo.user.tweet.controller;

import com.example.twitterdemo.user.tweet.entity.TweetResponse;
import com.example.twitterdemo.user.tweet.usecase.TweetUseCase;
import com.example.twitterdemo.user.tweet.entity.TweetAddRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tweets")
@RequiredArgsConstructor
public class TweetController {
    private final TweetUseCase tweetUseCase;

    @PostMapping("/add_tweet")
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest request){
        return tweetUseCase.addTweet(request);
    }
}
