package com.kodilla.patterns2.observer.homework;

public class Task {

    private final String name;
    private String link;
    private String comments;

    public Task(String name, String link, String comments) {
        this.name = name;
        this.link = link;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public String getComments() {
        return comments;
    }
}

