package lv.javaguru.java2.hrsystem.core.services.validators.skill;

import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.employee.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddSkillRequestValidator {

    @Autowired
    private EmployeeValidator employeeValidator;

    public List<CoreError> validate(AddSkillRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateEmployeeId(request).ifPresent(errors::add);
        validateSkillName(request).ifPresent(errors::add);
        validateEmployeeIdExists(request).filter(errors::add);
        return errors;
    }

    private Optional<CoreError> validateEmployeeIdExists(AddSkillRequest request) {
        if (!employeeValidator.employeeExists(request.getEmployeeId())) {
            return Optional.of(new CoreError("employee id", " does not exist"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateEmployeeId(AddSkillRequest request) {
        if (request.getEmployeeId() == null) {
            return Optional.of(new CoreError("employee id", " Must not be empty!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateSkillName(AddSkillRequest request) {
        if (isEmpty(request.getSkillName())) {
            return Optional.of(new CoreError("employee skill", " Must not be empty!"));
        }
        return Optional.empty();
    }

    private boolean isEmpty(String value) {
        return value == null || value.isEmpty() || value.isBlank();
    }
}