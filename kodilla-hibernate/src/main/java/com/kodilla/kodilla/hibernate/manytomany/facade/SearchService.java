package com.kodilla.kodilla.hibernate.manytomany.facade;

import com.kodilla.kodilla.hibernate.manytomany.Company;
import com.kodilla.kodilla.hibernate.manytomany.Employee;
import com.kodilla.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public boolean validateInput(String partialName) {
        return (partialName != null
                && !(partialName.isEmpty())
                && partialName.length() > 2
                && !(partialName.trim().isEmpty()));
    }

    public String findCompaniesNames(String partialName) {
        List<Company> listOfCompanies = companyDao.retrieveNameContaining(partialName);
        return listOfCompanies.stream().map(c -> c.getName()).collect(Collectors.joining(","));
    }

    public String findEmployeesNames(String partialName) {
        List<Employee> listOfEmployees = employeeDao.retrieveNameContaining(partialName);
        return listOfEmployees.stream().map(e -> e.getFirstname() + " " + e.getLastname()).collect(Collectors.joining(","));
    }
}
