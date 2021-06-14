package lv.javaguru.java2.hrsystem.core.services.validators.employee;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    @Autowired
    private ORMEmployeeRepository ormEmployeeRepository;

    public boolean employeeExists(Long employeeId) {
        return ormEmployeeRepository.getAllEmployees().stream()
                .anyMatch(e -> e.getId().equals(employeeId));
    }
}