package com.kodilla.patterns.factory.tasks;

import java.util.*;

public class PaintingTask implements Task {

    private final String taskName;
    private final String color;
    private final String whatToPaint;

    private final Set<String> thingsToPaint = new HashSet<>(){{
        add("BEDROOM");
        add("KITCHEN");
        add("WALLS");
    }};

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    public boolean executeTask() {
        return ((taskName != null) && (color != null) &&
       (Arrays.asList(PaintColor.values()).toString().contains(color.toUpperCase()))
                && (whatToPaint != null) && thingsToPaint.contains(whatToPaint.toUpperCase()));
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean isTaskExecuted() {
        return executeTask();
    }
}




