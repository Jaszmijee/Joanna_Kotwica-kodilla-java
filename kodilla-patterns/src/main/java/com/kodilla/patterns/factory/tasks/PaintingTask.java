package com.kodilla.patterns.factory.tasks;

import java.util.*;

public class PaintingTask implements Task {

    private final String taskName;
    private final PaintColor color;
    private final String whatToPaint;

    private final Set<String> thingsToPaint = new HashSet<>(){{
        add("BEDROOM");
        add("KITCHEN");
        add("WALLS");
    }};

    public PaintingTask(String taskName, PaintColor color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    public boolean executeTask() {
        return ((taskName != null) && (color != null));
    }

    public String getTaskName() {
        return this.taskName;
    }

    public boolean isTaskExecuted() {
        return executeTask();
    }
}




