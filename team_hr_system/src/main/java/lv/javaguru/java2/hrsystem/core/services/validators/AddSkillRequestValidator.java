package lv.javaguru.java2.hrsystem.core.services.validators;

import lv.javaguru.java2.hrsystem.core.requests.AddSkillRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AddSkillRequestValidator {

    public List<CoreError> validate(AddSkillRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateEmployeeId(request).ifPresent(errors::add);
        validateSkillName(request).ifPresent(errors::add);
        return errors;
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