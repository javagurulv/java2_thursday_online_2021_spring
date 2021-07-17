package lv.javaguru.java2.hrsystem.core.services.validators.employee;

import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.AddEmployeeWithTitleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.title.TitleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddEmployeeWithTitleValidator {

    @Autowired
    private TitleValidator titleValidator;

    public List<CoreError> validate(AddEmployeeWithTitleRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validateLastName(request).ifPresent(errors::add);
        validateTitle(request).ifPresent(errors::add);
        validateAge(request).ifPresent(errors::add);
        validateTitleAdded(request).ifPresent(errors::add);
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
        if (request.getTitle() != null && request.getTitle().equals("")) {
            return Optional.of(new CoreError("employee title", "Must not be whitespace!"));
        }
        return Optional.empty();
    }

    private boolean isEmpty(String field) {
        return field == null || field.isEmpty();
    }

    private Optional<CoreError> validateAge(AddEmployeeWithTitleRequest request) {
        if (request.getAge() < 18) {
            return Optional.of(new CoreError("employee age", "Must not be less than 18!"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateTitleAdded(AddEmployeeWithTitleRequest request) {
        if (request.getTitle() == null) {
            return Optional.empty();
        }
        if (validateTitle(request).isEmpty() && !titleValidator.titleExists(new EmployeeTitle(request.getTitle()))) {
            return Optional.of(new CoreError("this title", "is not added yet"));
        }
        return Optional.empty();
    }
}