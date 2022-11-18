package com.kodilla.patterns.strategy.social;

public class TwitterPublisher implements SocialPublisher {

    public String share(String post) {
        return " published on Twitter " + post;
    }
}
