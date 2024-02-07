package com.example.twitterdemo.user.profile.entity;

import com.example.twitterdemo.user.subsriptions.entity.Subscription;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @OneToMany
    @JoinColumn(name = "followed_id", referencedColumnName = "id")
    private List<Subscription> followers;
}
