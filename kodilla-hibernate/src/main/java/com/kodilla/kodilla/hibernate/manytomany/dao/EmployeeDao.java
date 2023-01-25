package com.kodilla.kodilla.hibernate.manytomany.dao;

import com.kodilla.kodilla.hibernate.manytomany.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query(nativeQuery = true)
    List<Employee> retrieveLastName(@Param("LASTNAME") String lastname);

    @Query(value = "SELECT * FROM EMPLOYEES " +
            "WHERE LASTNAME LIKE %:NAME%", nativeQuery = true)
    List<Employee> retrieveNameContaining(@Param("NAME") String nameFragment);
}