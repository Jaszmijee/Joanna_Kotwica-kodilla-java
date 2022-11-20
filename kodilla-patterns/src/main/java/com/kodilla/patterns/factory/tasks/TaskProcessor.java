package com.kodilla.patterns.factory.tasks;

public class TaskProcessor {

    public TaskDTO taskProcess(Task task) {
        boolean isExecuted = task.isTaskExecuted();
        return new TaskDTO(task, isExecuted);
    }
}
