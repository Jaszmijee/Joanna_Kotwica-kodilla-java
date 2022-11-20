package com.kodilla.patterns.factory.tasks;


public class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String tasksClass) {
        return switch (tasksClass) {
            case SHOPPING -> new ShoppingTask("ShoppingList", "milk", 0);
            case DRIVING -> new DrivingTask("Trasnport", "Airport", "Car");
            case PAINTING -> new PaintingTask("Painting bedroom", "Grey", "Bedroom");
            default -> null;
        };
    }
}
