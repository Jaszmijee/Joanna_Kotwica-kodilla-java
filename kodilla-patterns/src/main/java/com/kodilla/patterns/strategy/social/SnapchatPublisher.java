package com.kodilla.patterns.strategy.social;

public final class SnapchatPublisher implements SocialPublisher {

    public String share(String post) {
        return " published on Snapchat " + post;
    }
}
