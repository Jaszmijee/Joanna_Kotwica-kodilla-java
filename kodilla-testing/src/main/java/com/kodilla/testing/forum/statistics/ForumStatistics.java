package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    /*
    Prawda, Statistics statistics jest przekazywane do metody.
    ForumStatistics nie potrzebuje zmiennej Statistics statistics.
    */

    private int userNamesCount;
    private int postsCount;
    private int commentsCount;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public int getUserNamesCount() {
        return userNamesCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        this.userNamesCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();
        this.averagePostsPerUser = (double) statistics.postsCount() / statistics.usersNames().size();
        this.averageCommentsPerUser = (double) statistics.commentsCount() / statistics.usersNames().size();
        this.averageCommentsPerPost = (double) statistics.commentsCount() / statistics.postsCount();
    }

    public String showStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Forum statistics:").append("\nUsers: ").append(userNamesCount).append("Number of posts: ").append(postsCount).
                append("Number of comments: ").append(commentsCount).
                append("Comments per User: ").append(averageCommentsPerUser).
                append("Posts per User: ").append(averagePostsPerUser).
                append("Comments per Count: ").append(averageCommentsPerPost);
        return sb.toString();
    }

}
