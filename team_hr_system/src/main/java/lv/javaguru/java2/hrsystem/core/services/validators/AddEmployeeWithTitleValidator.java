package lv.javaguru.java2.hrsystem.core.services.validators;

import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.domain.EmployeeTitle;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@DIComponent
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
        if (isEmpty(request.getName())) {
            return Optional.of(new CoreError("employee name", "Must not be empty!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateLastName(AddEmployeeWithTitleRequest request) {
        if (isEmpty(request.getLastName())) {
            return Optional.of(new CoreError("employee last name", "Must not be empty!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateTitle(AddEmployeeWithTitleRequest request) {
        if (isEmpty(request.getTitle())) {
            return Optional.of(new CoreError("employee title", "Must not be empty!"));
        }
        else if (!isValidTitle(request.getTitle())) {
            return Optional.of(new CoreError("invalid title - " + request.getTitle(), " Must be selected from the pre-defined set!"));
        }
        return Optional.empty();
    }

    private boolean isEmpty(String field) {
        return field == null || field.isEmpty();
    }

    private boolean isValidTitle(String title) {
        EnumSet<EmployeeTitle> titles = EnumSet.allOf(EmployeeTitle.class);
        boolean valid;
        try {
            valid = titles.contains(EmployeeTitle.valueOf(title));
        }
        catch (IllegalArgumentException e) {
            valid = false;
        }
        return valid;
    }

    private Optional<CoreError> validateAge(AddEmployeeWithTitleRequest request) {
        if (request.getAge() < 18) {
            return Optional.of(new CoreError("employee age", "Must not be less than 18!"));
        }
        return Optional.empty();
    }
}