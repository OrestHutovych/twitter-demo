package com.example.twitterdemo.user.subsriptions.entity.response;

import java.util.Collection;

public record FollowerPageResponse(Collection<FollowerResponse> followers) {
}
