package com.kodilla.kodilla.hibernate.task.dao;

import com.kodilla.kodilla.hibernate.tasklist.TaskList;
import com.kodilla.kodilla.hibernate.tasklist.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    public void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("Test: List_Name", "Test: List_Description");
        taskListDao.save(taskList);

        // When
        Optional<TaskList> optionalTaskList = taskListDao.findByListName("Test: List_Name");

        //Then
        assertTrue(optionalTaskList.isPresent());

        //CleanUp
        int taskListId = taskList.getId();
        taskListDao.deleteById(taskListId);
    }
}

