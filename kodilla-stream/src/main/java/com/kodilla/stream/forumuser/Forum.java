package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> forumUserList = new ArrayList<>();

    public Forum() {
        this.forumUserList.add(new ForumUser(1, "aaa", 'M', 2020, 12, 25, 20));
        this.forumUserList.add(new ForumUser(2, "bbb", 'F', 2010, 11, 24, 400));
        this.forumUserList.add(new ForumUser(3, "ccc", 'M', 2000, 10, 23, 25));
        this.forumUserList.add(new ForumUser(4, "ddd", 'F', 1990, 9, 22, 0));
        this.forumUserList.add(new ForumUser(5, "eee", 'M', 1980, 8, 21, 10));
        this.forumUserList.add(new ForumUser(6, "fff", 'F', 1970, 7, 20, 20000));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUserList);
    }

}
