package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LoginValidator {
    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(RegistrationRequest request) {
        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateEmail(RegistrationRequest request) {
        return (request.getEmail() == null || request.getEmail().isEmpty())
                ? Optional.of(new CoreError("Email", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePassword(RegistrationRequest request) {
        return (request.getPassword() == null || request.getPassword().isEmpty())
                ? Optional.of(new CoreError("Password", "Must not be empty"))
                : Optional.empty();
    }
}
