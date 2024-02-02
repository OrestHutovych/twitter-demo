package com.example.twitterdemo.user.profile.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_profiles", schema = "twitter")
public class UserProfile {
    @Id
    private Long id;
    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;
    @Column(name = "image_link", nullable = false)
    private String imageLink;
}
