package lv.javaguru.java2.hrsystem.core.services.validators;

import lv.javaguru.java2.hrsystem.core.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    @Autowired
    private Database database;

    public boolean employeeExists(Long employeeId) {
        return database.getAllEmployees().stream()
                .anyMatch(e -> e.getId().equals(employeeId));
    }
}