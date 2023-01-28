package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class Trainee implements Observable {

    private final String name;
    private final Mentor mentor;
    private final Deque<Task> tasks;

    public Trainee(String name, Mentor mentor) {
        this.name = name;
        this.mentor = mentor;
        tasks = new ArrayDeque<>();
    }

    public void sendTask(Task task) {
        tasks.offerFirst(task);
        notifyMentor();
    }

    @Override
    public void notifyMentor() {
        mentor.update(this);
    }

    public Deque<Task> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    public Mentor getMentor() {
        return mentor;
    }
}