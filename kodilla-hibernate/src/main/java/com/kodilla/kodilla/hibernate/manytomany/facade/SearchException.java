package com.kodilla.kodilla.hibernate.manytomany.facade;

public class SearchException extends Exception {

    public static String COMPANY_NOT_FOUND = "Company was not found";
    public static String EMPLOYEE_NOT_FOUND = "Employee was not found";
    public static String INVALID_INPUT = "Query cannot be shorter than 3 characters";

    public SearchException(String message) {
        super(message);
    }
}
