package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Forum usersOnForum = new Forum();
        Map<Integer, ForumUser> selectedUsers;
        selectedUsers = usersOnForum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> forumUser.getDateOfBirth().getYear() <= 2002)
                .filter(forumUser -> forumUser.getPostNumber() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        System.out.println("Selected Users: ");
        selectedUsers.entrySet().stream().map(entry -> entry.getKey() + " " + entry.getValue())
                .forEach(entry -> System.out.println(entry));
    }
}


