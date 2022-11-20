package com.kodilla.patterns.factory.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

    private final TaskProcessor taskProcessor = new TaskProcessor();

    private List<TaskDTO> taskExecutionCheckList = new ArrayList<>();

    public void addToTaskExecutionCheckList(Task task) {
        this.taskExecutionCheckList.add(taskProcessor.taskProcess(task));
    }
}