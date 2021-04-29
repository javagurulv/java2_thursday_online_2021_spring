package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeRequestValidator;
import lv.javaguru.java2.hrsystem.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;

import java.util.List;

public class AddEmployeeService {

    private Database database;
    private AddEmployeeRequestValidator validator;

    public AddEmployeeService(Database database, AddEmployeeRequestValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public AddEmployeeResponse execute(AddEmployeeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddEmployeeResponse(errors);
        }

        Employee employee = new Employee(request.getName(), request.getLastName(), request.getAge());
        database.saveEmployee(employee);
        return new AddEmployeeResponse(employee);
    }

}
