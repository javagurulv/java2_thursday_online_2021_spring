package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.Paging;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.SearchEmployeesRequestValidator;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesResponse;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.List;
import java.util.stream.Collectors;

public class SearchEmployeesService {
    private final Database database;
    private final SearchEmployeesRequestValidator validator;

    public SearchEmployeesService(Database database, SearchEmployeesRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchEmployeesResponse execute(SearchEmployeesRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new SearchEmployeesResponse(errors, null);
        }

        List<Employee> employee = search(request);

        employee = paging(employee, request.getPaging());

        return new SearchEmployeesResponse(null, employee);
    }

    public List<Employee> search(SearchEmployeesRequest request) {

        List<Employee> employees = null;

        if (request.isNameProvided() && !request.isTitleProvided()) {
            employees = database.getEmployeesByName(request.getName());
        }
        if (request.isTitleProvided() && !request.isNameProvided()) {
            employees = database.getEmployeesByTitle(EmployeeTitle.valueOf(request.getEmployeeTitle()));
        }
        if (request.isNameProvided() && request.isTitleProvided()) {
            employees = database.getEmployeesByTitleAdnName(EmployeeTitle.valueOf(request.getEmployeeTitle()), request.getName());
        }
        return employees;
    }

    private List<Employee> paging(List<Employee> books, Paging paging) {

        if (paging != null) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return books.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return books;
        }
    }
}