package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LogInValidator {

    public List<CoreError> validate(LogInRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateUsername(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateUsername(LogInRequest request) {
        return (request.getUsername() == null || request.getUsername().isEmpty())
                ? Optional.of(new CoreError("Username", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePassword(LogInRequest request) {
        return (request.getPassword() == null || request.getPassword().isEmpty())
                ? Optional.of(new CoreError("Password", "Must not be empty"))
                : Optional.empty();
    }
}
