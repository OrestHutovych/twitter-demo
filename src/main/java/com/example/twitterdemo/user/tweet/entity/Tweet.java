package com.example.twitterdemo.user.tweet.entity;

import com.example.twitterdemo.user.profile.entity.UserProfile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Getter
@Setter
@Table(name = "tweets", schema = "twitter")
@EntityListeners(AuditingEntityListener.class)
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "message")
    private String message;
    @CreatedDate
    @Column(name = "created_timestamp", nullable = false, updatable = false)
    private Instant createdTimestamp;
    @LastModifiedDate
    @Column(name = "edited_timestamp", nullable = false)
    private Instant editedTimestamp;
    @ManyToOne(optional = false)
    private UserProfile userProfile;
}
