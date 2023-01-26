package com.kodilla.kodilla.hibernate.manytomany.dao;

import com.kodilla.kodilla.hibernate.manytomany.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query(nativeQuery = true)
    List<Company> retrieveNameStartingWith(@Param("COMPANY_SHORT_NAME") String shortname);

    @Query(value = "SELECT * FROM COMPANIES " +
            "WHERE COMPANY_NAME LIKE %:NAME%", nativeQuery = true)
    List<Company> retrieveNameContaining(@Param("NAME") String nameFragment);
}
