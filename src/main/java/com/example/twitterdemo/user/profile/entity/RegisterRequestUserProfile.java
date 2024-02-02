package com.example.twitterdemo.user.profile.entity;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequestUserProfile(@NotBlank String nickname, @NotBlank String imageLink) {
}
