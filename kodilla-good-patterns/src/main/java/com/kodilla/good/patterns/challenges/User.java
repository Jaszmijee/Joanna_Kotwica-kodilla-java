package com.kodilla.good.patterns.challenges;

final class User {

    private final String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return userName;
    }

}
