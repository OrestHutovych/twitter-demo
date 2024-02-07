package com.example.twitterdemo.user.timeline.entity.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record TimelineFindRequest(
        @Min(0) int page,
        @Min(25) @Max(100) int limit
) {
}
