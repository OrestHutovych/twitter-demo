package com.example.twitterdemo.user.subsriptions.usercase.impl;

import com.example.twitterdemo.user.profile.api.service.CurrentUserProfileApiService;
import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.subsriptions.entity.request.TweetFindRequest;
import com.example.twitterdemo.user.subsriptions.entity.response.FollowerPageResponse;
import com.example.twitterdemo.user.subsriptions.entity.response.FollowerResponse;
import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import com.example.twitterdemo.user.subsriptions.service.SubscriptionService;
import com.example.twitterdemo.user.subsriptions.usercase.SubscriptionFindFollowersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SubscriptionFindFollowersUseCaseImpl implements SubscriptionFindFollowersUseCase {
    private final CurrentUserProfileApiService currentUserProfileApiService;
    private final SubscriptionService subscriptionService;
    @Override
    public FollowerPageResponse getFollowers(TweetFindRequest tweetFindRequest) {
        UserProfile userProfile = currentUserProfileApiService.currentUserProfile();

        Sort sort = Sort.by(Sort.Direction.DESC, "createdTimestamp");
        Pageable pageable = PageRequest.of(tweetFindRequest.page(), tweetFindRequest.limit(), sort);
        Page<Subscription> subscriptions = subscriptionService.findAllFollowerByUserProfile(userProfile, pageable);

        List<FollowerResponse> response = subscriptions
                .stream()
                .map(item -> new FollowerResponse(
                        item.getId(),
                        item.getFollower().getId(),
                        item.getFollower().getNickname(),
                        item.getFollower().getImageLink(),
                        item.getCreatedTimestamp())
                ).toList();
        return new FollowerPageResponse(response);
    }
}
