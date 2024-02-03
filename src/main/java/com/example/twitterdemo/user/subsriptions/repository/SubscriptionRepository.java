package com.example.twitterdemo.user.subsriptions.repository;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    boolean existsByFollowerAndFollowed(UserProfile follower, UserProfile followed);
    Optional<Subscription> findByFollowerAndFollowed(UserProfile follower, UserProfile followed);
}
