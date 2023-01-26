package com.kodilla.kodilla.hibernate.manytomany.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SearchFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    private SearchService searchService;

    public SearchFacade(SearchService searchService) {
        this.searchService = searchService;
    }

    public String searchForCompany(String searchName) throws SearchException {
        LOGGER.info("Validating Company search parameter: " + searchName);
        boolean isInputValid = searchService.validateInput(searchName);
        if (!isInputValid) {
            LOGGER.error(SearchException.INVALID_INPUT);
            throw new SearchException(SearchException.INVALID_INPUT);
        }
        LOGGER.info("Searching for companies containing: " + searchName);
        String listOfCompanies = searchService.findCompaniesNames(searchName);
        if (listOfCompanies.isEmpty()) {
            LOGGER.error(SearchException.COMPANY_NOT_FOUND);
            throw new SearchException(SearchException.COMPANY_NOT_FOUND);
        }
        return "List of companies containing " + searchName + " :"
                + "\n" + listOfCompanies;
    }

    public String searchForEmployee(String searchName) throws SearchException {
        LOGGER.info("Validating Employee search parameter: " + searchName);
        boolean isInputValid = searchService.validateInput(searchName);
        if (!isInputValid) {
            LOGGER.error(SearchException.INVALID_INPUT);
            throw new SearchException(SearchException.INVALID_INPUT);
        }
        LOGGER.info("Searching for employees containing: " + searchName);
        String listOfEmployees = searchService.findEmployeesNames(searchName);
        if (listOfEmployees.isEmpty()) {
            LOGGER.error(SearchException.EMPLOYEE_NOT_FOUND);
            throw new SearchException(SearchException.EMPLOYEE_NOT_FOUND);
        }
        return "List of employees with the last name containing " + searchName + " :"
                + "\n" + listOfEmployees;
    }

}
