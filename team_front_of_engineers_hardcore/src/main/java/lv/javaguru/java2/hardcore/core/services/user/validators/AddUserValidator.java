package lv.javaguru.java2.hardcore.core.services.user.validators;


import lv.javaguru.java2.hardcore.core.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class AddUserValidator {

    public List<CoreError> validate(AddUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateName(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(AddUserRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("Name", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePassword(AddUserRequest request) {
        return (request.getPassword() == null || request.getPassword().isEmpty())
                ? Optional.of(new CoreError("Password", "Must not be empty"))
                : Optional.empty();
    }
}
