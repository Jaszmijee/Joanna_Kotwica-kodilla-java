package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    TaskFactory taskFactory = new TaskFactory();

    @Test
    public void testMakeTaskForShopping() {

        // When & Then
        Task task = taskFactory.makeTask(TaskFactory.SHOPPING);

        assertEquals(ShoppingTask.class, task.getClass());
        assertEquals("ShoppingList", task.getTaskName());
        assertFalse(task.isTaskExecuted());
    }

    @Test
    public void testMakeTaskForDriving() {
        // When & Then
        Task task = taskFactory.makeTask(TaskFactory.DRIVING);

        assertEquals(DrivingTask.class, task.getClass());
        assertEquals("Trasnport", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    public void testMakeTaskForPainting() {
        // When & Then
        Task task = taskFactory.makeTask(TaskFactory.PAINTING);

        assertEquals(PaintingTask.class, task.getClass());
        assertEquals("Painting bedroom", task.getTaskName());
        assertTrue(task.isTaskExecuted());
    }

    @Test
    public void testMakeTaskForDefaultValue() {

        assertNull(taskFactory.makeTask("Digging"));
    }
}

