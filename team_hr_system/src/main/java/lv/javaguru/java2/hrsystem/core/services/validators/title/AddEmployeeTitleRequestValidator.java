package lv.javaguru.java2.hrsystem.core.services.validators.title;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddEmployeeTitleRequestValidator {

    public List<CoreError> validate(AddEmployeeTitleRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateTitle(request).ifPresent(errors::add);
        validateDescription(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateTitle(AddEmployeeTitleRequest request) {
        if (request.getTitle().isEmpty() || request.getTitle() == null) {
            return Optional.of(new CoreError("title", " Must not be empty"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateDescription(AddEmployeeTitleRequest request) {
        if (request.getDescription().isEmpty() || request.getDescription() == null) {
            return Optional.of(new CoreError("description", " Must not be empty"));
        }
        return Optional.empty();
    }
}