package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddEmployeeWithTitleValidator {

    public List<CoreError> validate(AddEmployeeWithTitleRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validateLastName(request).ifPresent(errors::add);
        validateTitle(request).ifPresent(errors::add);
        validateAge(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddEmployeeWithTitleRequest request) {
        if (request.getName() == null || request.getName().isEmpty()) {
            return Optional.of(new CoreError("employee name", "Must not be empty!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateLastName(AddEmployeeWithTitleRequest request) {
        if (request.getName() == null || request.getLastName().isEmpty()) {
            return Optional.of(new CoreError("employee last name", "Must not be empty!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateTitle(AddEmployeeWithTitleRequest request) {
        if (request.getName() == null || request.getTitle().isEmpty()) {
            return Optional.of(new CoreError("employee title", "Must not be empty!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateAge(AddEmployeeWithTitleRequest request) {
        if (request.getAge() < 18) {
            return Optional.of(new CoreError("employee age", "Must not be less than 18!"));
        }
        return Optional.empty();
    }
}