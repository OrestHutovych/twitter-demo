package com.example.twitterdemo.security.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
public record RegisterRequest(
        @NotBlank @Email String username,
        @NotBlank String password) {
}
