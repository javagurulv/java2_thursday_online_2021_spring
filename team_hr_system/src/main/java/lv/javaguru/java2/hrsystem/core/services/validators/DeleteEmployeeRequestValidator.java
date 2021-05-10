package lv.javaguru.java2.hrsystem.core.services.validators;

import lv.javaguru.java2.hrsystem.core.requests.DeleteEmployeeRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class DeleteEmployeeRequestValidator {

    public List<CoreError> validate(DeleteEmployeeRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateEmployeeId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateEmployeeId(DeleteEmployeeRequest request) {
        if (request.getId() == null) {
            return Optional.of(new CoreError("employee id", " Must not be empty!"));
        }
        return Optional.empty();
    }
}