package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeRequestValidator;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddEmployeeService {

    @Autowired private Database database;
    @Autowired private AddEmployeeRequestValidator validator;

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
