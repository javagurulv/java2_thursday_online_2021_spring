package lv.javaguru.java2.hrsystem.core.services.validators;

import lv.javaguru.java2.hrsystem.core.database.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean employeeExists(Long employeeId) {
        return employeeRepository.getAllEmployees().stream()
                .anyMatch(e -> e.getId().equals(employeeId));
    }
}