package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task {

    private final String taskName;
    private final String whatToBuy;
    private final double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    public boolean executeTask() {
        return (taskName != null && whatToBuy != null && quantity > 0);
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean isTaskExecuted() {
        return executeTask();
    }
}
