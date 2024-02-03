package com.example.twitterdemo.user.subsriptions.entity;

import jakarta.validation.constraints.NotNull;

public record SubscriptionRequest(@NotNull Long followId) {
}
