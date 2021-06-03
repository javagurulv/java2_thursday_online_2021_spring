package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.EmployeeRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class AddEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddEmployeeRequestValidator validator;

    public AddEmployeeResponse execute(AddEmployeeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddEmployeeResponse(errors);
        }

        Employee employee = new Employee(request.getName(), request.getLastName(), request.getAge());
       // employeeRepository.saveEmployee(employee);
        BigInteger id = employeeRepository.saveEmployeeAndReturnID(employee);
        employee.setId(id.longValue());
        return new AddEmployeeResponse(employee);
    }
}