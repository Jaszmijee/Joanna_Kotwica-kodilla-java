package com.kodilla.patterns.strategy.social;

public final class FacebookPublisher implements SocialPublisher {

    public String share(String post) {
        return " published on Facebook: " + post;
    }
}
