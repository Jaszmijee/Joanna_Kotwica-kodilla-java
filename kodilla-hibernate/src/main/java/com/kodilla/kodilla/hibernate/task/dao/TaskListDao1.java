package com.kodilla.kodilla.hibernate.task.dao;

import com.kodilla.kodilla.hibernate.task.TaskList1;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface TaskListDao1 extends CrudRepository<TaskList1, Integer> {
}
