package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.GetEmployeesByTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetEmployeesByTitleResponse;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.List;

public class GetEmployeesByTitleService {
    private final Database database;
    private final GetEmployeesWithTitleValidator validator = new GetEmployeesWithTitleValidator();

    public GetEmployeesByTitleService(Database database) {
        this.database = database;
    }

    public GetEmployeesByTitleResponse execute(GetEmployeesByTitleRequest getEmployeesByTitleRequest) {
        List<CoreError> errors = validator.validate(getEmployeesByTitleRequest);
        List<Employee> employeesByTitle = database.getEmployeesByTitle(EmployeeTitle.valueOf(getEmployeesByTitleRequest.getEmployeeTitle()));
        return new GetEmployeesByTitleResponse(employeesByTitle);
    }
}