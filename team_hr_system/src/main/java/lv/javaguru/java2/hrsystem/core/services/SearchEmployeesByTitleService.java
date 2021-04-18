package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.SearchEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.SearchEmployeesByTitleResponse;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.List;

public class SearchEmployeesByTitleService {
    private final Database database;
    private final SearchEmployeesByTitleRequestValidator validator = new SearchEmployeesByTitleRequestValidator();

    public SearchEmployeesByTitleService(Database database) {
        this.database = database;
    }

    public SearchEmployeesByTitleResponse execute(SearchEmployeesByTitleRequest getEmployeesByTitleRequest) {
        List<CoreError> errors = validator.validate(getEmployeesByTitleRequest);
        if (!errors.isEmpty()) {
            return new SearchEmployeesByTitleResponse(errors, null);
        }
        List<Employee> employeesByTitle = database.getEmployeesByTitle(EmployeeTitle.valueOf(getEmployeesByTitleRequest.getEmployeeTitle()));
        return new SearchEmployeesByTitleResponse(null, employeesByTitle);
    }
}