package com.kodilla.patterns.strategy.social;

public final class TwitterPublisher implements SocialPublisher {

    public String share(String post) {
        return " published on Twitter " + post;
    }
}
