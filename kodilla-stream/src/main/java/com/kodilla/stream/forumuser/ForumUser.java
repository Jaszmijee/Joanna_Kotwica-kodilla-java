package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private int postNumber;

    public ForumUser(final int userID, final String userName, final char sex, final int year, final int month, final int day, int postNumber) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.postNumber = postNumber;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostNumber() {
        return postNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser forumUser)) return false;

        if (userID != forumUser.userID) return false;
        if (sex != forumUser.sex) return false;
        if (postNumber != forumUser.postNumber) return false;
        if (!userName.equals(forumUser.userName)) return false;
        return dateOfBirth.equals(forumUser.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = userID;
        result = 31 * result + userName.hashCode();
        result = 31 * result + (int) sex;
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + postNumber;
        return result;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", postNumber=" + postNumber +
                '}';
    }
}


