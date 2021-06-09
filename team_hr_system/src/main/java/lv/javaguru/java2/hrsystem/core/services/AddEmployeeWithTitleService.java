package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeWithTitleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddEmployeeWithTitleService {

    @Autowired
   // private EmployeeRepository employeeRepository;
    private ORMEmployeeRepository ormEmployeeRepository;

    @Autowired
    //private EmployeeTitleRepository employeeTitleRepository;
    private ORMEmployeeTitleRepository ormEmployeeTitleRepository;

    @Autowired
    private AddEmployeeWithTitleValidator validator;


    public AddEmployeeWithTitleResponse execute(AddEmployeeWithTitleRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddEmployeeWithTitleResponse(errors);
        }
        Employee employee = new Employee(
                request.getName(), request.getLastName(), request.getAge(), new EmployeeTitle(request.getTitle()));
       // BigInteger id = employeeRepository.saveEmployeeWithTitleAndReturnID(employee);
        Long id = ormEmployeeRepository.saveEmployee(employee);
        employee.setId(id);
        return new AddEmployeeWithTitleResponse(employee);
    }
}