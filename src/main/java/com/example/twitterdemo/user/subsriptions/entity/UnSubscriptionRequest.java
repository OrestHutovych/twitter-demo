package com.example.twitterdemo.user.subsriptions.entity;

import jakarta.validation.constraints.NotNull;

public record UnSubscriptionRequest(@NotNull Long followedId) {
}
