package com.kodilla.kodilla.hibernate.tasklist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<TaskList, Integer> {
    Optional<TaskList> findByListName(String listName);
}