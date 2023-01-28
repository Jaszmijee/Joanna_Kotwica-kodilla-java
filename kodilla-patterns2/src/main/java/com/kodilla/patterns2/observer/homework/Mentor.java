package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class Mentor implements Observer {
    private final String name;
    private List<Trainee> trainees;
    private int count;

    public Mentor(String name) {
        this.name = name;
        this.trainees = new ArrayList<>();
    }

    @Override
    public void update(Trainee trainee) {
        System.out.println("Hi, " + name + ", you have a new task from trainee: " + trainee.getName() + "\n"
                + "Title: " + trainee.getTasks().peekFirst().getName());
        count++;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public int getCount() {
        return count;
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }
}


