package com.kodilla.patterns.factory.tasks;

import java.util.HashSet;
import java.util.Set;

public class DrivingTask implements Task {

    private final String taskName;
    private final String where;
    private final String using;

    private Set<String> destination = new HashSet<>() {
        {
            add("AIRPORT");
            add("HOME");
            add("WORK");
            add("AUNT MARY");
        }
    };

    private Set<String> vehicles = new HashSet<>() {
        {
            add("CAR");
            add("BIKE");
            add("MOTORCYCLE");
        }
    };

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    public boolean executeTask() {
        return ((taskName != null) && (where != null) && (destination.contains(where.toUpperCase()))
                && (using != null) && (vehicles.contains(using.toUpperCase())));
    }

    public boolean isTaskExecuted() {
        return executeTask();
    }

    public String getTaskName() {
        return this.taskName;
    }
}


