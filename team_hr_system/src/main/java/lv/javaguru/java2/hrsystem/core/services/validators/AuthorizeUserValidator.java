package lv.javaguru.java2.hrsystem.core.services.validators;

import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AuthorizeUserValidator {
    public List<CoreError> validate (AuthorizeUserRequest request) {
        List<CoreError> errors = new ArrayList<>();

        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateEmail(AuthorizeUserRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("email", "Must not be empty!"));
        } else {
            return Optional.empty();

        }
    }

    private Optional<CoreError> validatePassword(AuthorizeUserRequest request) {
        if (request.getPassword() == null || request.getPassword().isEmpty()){
            return Optional.of(new CoreError("password", "Must not be empty!"));
        } else {
            return Optional.empty();
        }
    }
}
