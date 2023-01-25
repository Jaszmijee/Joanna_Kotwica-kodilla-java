package com.kodilla.kodilla.hibernate.manytomany.facade;

import com.kodilla.kodilla.hibernate.manytomany.Company;
import com.kodilla.kodilla.hibernate.manytomany.Employee;
import com.kodilla.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SearchFacadeTest {

    @Autowired
    SearchFacade searchFacade;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    CompanyDao companyDao;

    @Test
    void searchForCompanyWrongInput() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //When & Then
        assertAll(
                () -> assertThrows(SearchException.class, () -> searchFacade.searchForCompany(null)),
                () -> assertThrows(SearchException.class, () -> searchFacade.searchForCompany("")),
                () -> assertThrows(SearchException.class, () -> searchFacade.searchForCompany("gr"))
        );

        //Cleanup
        companyDao.deleteAll();
    }

    @Test
    void searchForCompanyCompanyDoestNotExist() {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //When & Then
        assertThrows(SearchException.class, () -> searchFacade.searchForCompany("banana"));

        //Cleanup
        companyDao.deleteAll();
    }

    @Test
    void searchForCompanyCompanyExist() throws SearchException {
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        //When & Then
        assertEquals("List of companies containing ach :" + "\nSoftware Machine", searchFacade.searchForCompany("ach"));

        //Cleanup
        companyDao.deleteAll();
    }

    @Test
    void searchForEmployeeWrongInput() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        //When & Then
        assertAll(
                () -> assertThrows(SearchException.class, () -> searchFacade.searchForEmployee(null)),
                () -> assertThrows(SearchException.class, () -> searchFacade.searchForEmployee("")),
                () -> assertThrows(SearchException.class, () -> searchFacade.searchForEmployee("gr"))
        );

        //Cleanup
        employeeDao.deleteAll();
    }

    @Test
    void searchForEmployeeDoestNotExist() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        //When & Then
        assertThrows(SearchException.class, () -> searchFacade.searchForEmployee("Baggins"));

        //Cleanup
        employeeDao.deleteAll();
    }

    @Test
    void searchForEmployeeExist() throws SearchException {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);

        //When & Then
        assertEquals("List of employees with the last name containing ith :" + "\nJohn Smith", searchFacade.searchForEmployee("ith"));

        //Cleanup
        employeeDao.deleteAll();
    }
}



