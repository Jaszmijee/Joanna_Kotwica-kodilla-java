package com.kodilla.kodilla.hibernate.tasklist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        List<TaskList> optionalTaskList = taskListDao.findByListName("Test: List_Name");

        //Then
        assertEquals(1, optionalTaskList.size());

        //CleanUp
        int taskListId = taskList.getId();
        taskListDao.deleteById(taskListId);
    }

    @Test
    public void testFindByListName1() {
        // Given
        TaskList taskList = new TaskList("Test: List_Name", "Test: List_Description");
        taskListDao.save(taskList);

        // When
        String name = taskList.getListName();
        List<TaskList> optionalTaskList = taskListDao.findByListName(name);

        //Then
        assertEquals(1, optionalTaskList.size());
        assertEquals(optionalTaskList.get(0).getListName(),"Test: List_Name");

        //CleanUp
        int taskListId = taskList.getId();
        taskListDao.deleteById(taskListId);
    }
}

