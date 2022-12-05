package com.kodilla.kodilla.hibernate.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TASKLIST1")
public class TaskList1 {

    private int id;
    private String listName;
    private String description1;
    private List<Task> tasks = new ArrayList<>();


    public TaskList1(String listName1, String description1) {
        this.listName = listName1;
        this.description1 = description1;
    }

    public TaskList1(){
    }


@Id
@NotNull
@GeneratedValue
@Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }


@Column(name = "LISTNAME1")
    public String getListName() {
        return listName;
    }

  @Column(name = "DESCRIPTION1")
  public String getDescription1() {
        return description1;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    @OneToMany(
            targetEntity = Task.class,
            mappedBy = "taskList1",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
