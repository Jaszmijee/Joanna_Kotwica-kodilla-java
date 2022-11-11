package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<String> tasks;

    public TaskList(String taskTitle) {
        this.tasks = new ArrayList<>();
    }

    public List<String> getTasks() {
        return this.tasks;
    }
}
