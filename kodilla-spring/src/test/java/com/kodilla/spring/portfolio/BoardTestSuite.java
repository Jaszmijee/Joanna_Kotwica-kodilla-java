package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When && Then
        board.getToDoList().getTasks().add("ToDo task1");
        board.getInProgressList().getTasks().add("InProgress task1");
        board.getDoneList().getTasks().add("Done task1");

        assertEquals(1, board.getToDoList().getTasks().size());
        assertEquals(1, board.getInProgressList().getTasks().size());
        assertEquals(1, board.getDoneList().getTasks().size());

        assertEquals("ToDo task1", board.getToDoList().getTasks().get(0));
        assertEquals("InProgress task1", board.getInProgressList().getTasks().get(0));
        assertEquals("Done task1", board.getDoneList().getTasks().get(0));

    }
}

