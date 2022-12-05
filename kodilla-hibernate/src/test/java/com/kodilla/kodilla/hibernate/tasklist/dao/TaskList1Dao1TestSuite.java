package com.kodilla.kodilla.hibernate.tasklist.dao;

import com.kodilla.kodilla.hibernate.task.Task;
import com.kodilla.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.kodilla.hibernate.task.TaskList1;
import com.kodilla.kodilla.hibernate.task.dao.TaskListDao1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class TaskList1Dao1TestSuite {

    private static String LISTNAME = "First List";

    @Autowired
    TaskListDao1 taskListDao1;

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList1 taskList1 = new TaskList1(LISTNAME, "ToDo tasks");
        taskList1.getTasks().add(task);
        taskList1.getTasks().add(task2);
        task.setTaskList1(taskList1);
        task2.setTaskList1(taskList1);

        //When
        taskListDao1.save(taskList1);
        int id = taskList1.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        //  taskListDao1.deleteById(id);
    }
}


