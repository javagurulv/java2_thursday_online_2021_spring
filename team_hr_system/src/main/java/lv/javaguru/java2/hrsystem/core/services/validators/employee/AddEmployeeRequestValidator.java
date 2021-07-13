package lv.javaguru.java2.hrsystem.core.services.validators.employee;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddEmployeeRequestValidator {

    public List<CoreError> validate(AddEmployeeRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validateLastName(request).ifPresent(errors::add);
        validateAge(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddEmployeeRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateLastName(AddEmployeeRequest request) {
        return (request.getLastName() == null || request.getLastName().isEmpty())
                ? Optional.of(new CoreError("last name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAge(AddEmployeeRequest request) {
        return (request.getAge() <= 0)
                ? Optional.of(new CoreError("age", "Must be > 0!"))
                : Optional.empty();
    }

}
