package com.example.twitterdemo.user.tweet.controller;

import com.example.twitterdemo.user.tweet.entity.request.TweetEditRequest;
import com.example.twitterdemo.user.tweet.entity.request.TweetFindRequest;
import com.example.twitterdemo.user.tweet.entity.request.TweetPageResponse;
import com.example.twitterdemo.user.tweet.entity.response.TweetResponse;
import com.example.twitterdemo.user.tweet.usecase.FindTweetUseCase;
import com.example.twitterdemo.user.tweet.usecase.TweetDeleteUseCase;
import com.example.twitterdemo.user.tweet.usecase.TweetEditUseCase;
import com.example.twitterdemo.user.tweet.usecase.TweetUseCase;
import com.example.twitterdemo.user.tweet.entity.request.TweetAddRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/tweets")
@RequiredArgsConstructor
public class TweetController {
    private final TweetUseCase tweetUseCase;
    private final TweetEditUseCase tweetEditUseCase;
    private final TweetDeleteUseCase tweetDeleteUseCase;
    private final FindTweetUseCase findTweetUseCase;

    @PostMapping("/add_tweet")
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest request){
        return tweetUseCase.addTweet(request);
    }

    @PutMapping("/edit_tweet")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TweetResponse editTweet(@Valid @RequestBody TweetEditRequest request){
        return tweetEditUseCase.editTweet(request);
    }

    @DeleteMapping("/{tweet_id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTweet(@PathVariable(name = "tweet_id") long tweetId){
        tweetDeleteUseCase.deleteTweet(tweetId);
    }

    @GetMapping()
    public TweetPageResponse findTweets(@RequestParam(name = "page") int page,
                                        @RequestParam(name = "limit") int limit){
        TweetFindRequest findRequest = new TweetFindRequest(page, limit);
        return findTweetUseCase.findTweets(findRequest);
    }
}
