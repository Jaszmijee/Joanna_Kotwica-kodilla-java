package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import static java.lang.Double.NaN;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class BoardTestSuite {

    @Test
    void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        assertEquals(3, project.getTaskLists().size());
    }

    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }
    @Test
    void testAddTaskListFindUsersTasks() {
        //Given
        Board project = prepareTestData();

        //When
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap(l -> l.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(toList());

        //Then
        assertEquals(2, tasks.size());
        assertEquals(user, tasks.get(0).getAssignedUser());
        assertEquals(user, tasks.get(1).getAssignedUser());
    }
    @Test
    void testAddTaskListFindOutdatedTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());

        //Then
        assertEquals(1, tasks.size());
        assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }

    @Test
    void testAddTaskListFindLongTasks() {
        //Given
        Board project = prepareTestData();

        //When
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(tl -> tl.getTasks().stream())
                .map(Task::getCreated)
                .filter(d -> d.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();

        //Then
        assertEquals(2, longTasks);
    }

    @DisplayName("Average time spent on task version1")
    @Test
    public void testAddTaskListAverageWorkingOnTaskV1(){
        //Given
        Board project = prepareTestData();

        //When
        long totalDaysFromBeingCreatedV1 = project.getTaskLists().stream()
        .filter(list -> list.getName().equals("In progress"))
        .flatMap(list -> list.getTasks().stream())
        .map(days -> days.getCreated().until(LocalDate.now()))
        .map(days -> days.get(ChronoUnit.DAYS))
        .reduce(0L, (sum, current) -> sum = sum +current);

        long numberOfTasksInProgressTillNowV1 = project.getTaskLists().stream()
                .filter(list -> list.getName().equals("In progress"))
                .flatMap(list -> list.getTasks().stream())
                .count();

        double resultAverageDaysPerTaskInProgressV1 = (double) totalDaysFromBeingCreatedV1 / numberOfTasksInProgressTillNowV1;
        double expectedAverageDaysPerTaskInProgress = (double) (20 + 10 + 0) / 3;

        //Then
        assertEquals(expectedAverageDaysPerTaskInProgress, resultAverageDaysPerTaskInProgressV1, 0.1);

    }
    @DisplayName("Average time spent on task version2")
    @Test
    public void testAddTaskListAverageWorkingOnTaskV2(){
        //Given
        Board project = prepareTestData();

        //When
        var resultAverageDaysPerTaskInProgressVar = project.getTaskLists().stream()
                .filter(list -> list.getName().equals("In progress"))
                .flatMap(list -> list.getTasks().stream())
                .map(days -> days.getCreated().until(LocalDate.now()))
                .mapToDouble(days -> days.get(ChronoUnit.DAYS))
                .average();

        double expectedAverageDaysPerTaskInProgress = (double) (20 + 10 + 0) / 3;
        double resultAverageDaysPerTaskInProgressV2 = resultAverageDaysPerTaskInProgressVar.orElse(NaN);

       //Then
        assertEquals(expectedAverageDaysPerTaskInProgress, resultAverageDaysPerTaskInProgressV2, 0.1);

    }

}

