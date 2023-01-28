package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MentorAndTraineeTestSuite {

    @Test
    public void testUpdate() {
        //Given
        Mentor mentor1 = new Mentor("aa");
        Mentor mentor2 = new Mentor("bb");

        Trainee trainee1 = new Trainee("q", mentor1);
        Trainee trainee2 = new Trainee("w", mentor1);
        Trainee trainee3 = new Trainee("e", mentor1);
        Trainee trainee4 = new Trainee("r", mentor2);
        Trainee trainee5 = new Trainee("s", mentor2);

        mentor1.addTrainee(trainee1);
        mentor1.addTrainee(trainee2);
        mentor1.addTrainee(trainee3);
        mentor2.addTrainee(trainee4);
        mentor2.addTrainee(trainee5);

        Task task1 = new Task("T1", "https://www.youtube.com/@Kodillacom", null);
        Task task2 = new Task("T2", "https://www.youtube.com/@Kodillacom", "problems");
        Task task3 = new Task("T3", "https://www.youtube.com/@Kodillacom", "no problems");

        //When
        trainee1.sendTask(task1);
        trainee2.sendTask(task2);
        trainee5.sendTask(task3);
        trainee4.sendTask(task1);
        trainee4.sendTask(task2);

        //Then
        assertEquals(2, mentor1.getCount());
        assertEquals(3, mentor2.getCount());
    }
}

