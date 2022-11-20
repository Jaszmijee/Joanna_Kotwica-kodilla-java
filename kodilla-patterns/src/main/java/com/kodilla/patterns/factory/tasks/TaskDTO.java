package com.kodilla.patterns.factory.tasks;

public class TaskDTO {

    private Task task;
    boolean isExecuted;

    public TaskDTO(Task task, boolean isExecuted) {
        this.task = task;
        this.isExecuted = isExecuted;
    }

    public Task getTask() {
        return task;
    }

    public boolean isExecuted() {
        return isExecuted;
    }
}
