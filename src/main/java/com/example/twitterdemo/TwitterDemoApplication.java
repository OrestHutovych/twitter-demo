package com.example.twitterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TwitterDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterDemoApplication.class, args);
    }

}
