package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.EmployeeRepository;
import lv.javaguru.java2.hrsystem.core.database.EmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.Employee;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.AddEmployeeWithTitleResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.AddEmployeeWithTitleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class AddEmployeeWithTitleService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeTitleRepository employeeTitleRepository;

    @Autowired
    private AddEmployeeWithTitleValidator validator;


    public AddEmployeeWithTitleResponse execute(AddEmployeeWithTitleRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddEmployeeWithTitleResponse(errors);
        }
        List<EmployeeTitle> employeeTitles = employeeTitleRepository.getAllUniqueTitles();
        if (employeeTitles.isEmpty()) {
            return new AddEmployeeWithTitleResponse(List.of(new CoreError("this title", "is not added yet")));
        }

        Employee employee = new Employee(
                request.getName(), request.getLastName(), request.getAge(), new EmployeeTitle(request.getTitle()));
        BigInteger id = employeeRepository.saveEmployeeWithTitleAndReturnID(employee);
        employee.setId(id.longValue());
        return new AddEmployeeWithTitleResponse(employee);
    }
}