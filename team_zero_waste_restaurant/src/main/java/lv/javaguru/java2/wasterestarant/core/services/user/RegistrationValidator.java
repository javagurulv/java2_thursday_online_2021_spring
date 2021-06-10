package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegistrationValidator {
    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(RegistrationRequest request) {
        validateUserRole(request).ifPresent(errors::add);
        validateName(request).ifPresent(errors::add);
        validateSurname(request).ifPresent(errors::add);
        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateUserRole(RegistrationRequest request) {
        return (request.getUserRole() == null)
                ? Optional.of(new CoreError("User role", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateName(RegistrationRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("Name", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateSurname(RegistrationRequest request) {
        return (request.getSurname() == null || request.getSurname().isEmpty())
                ? Optional.of(new CoreError("Surname", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateEmail(RegistrationRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("Email", "Must not be empty"));
        } else if (!request.getEmail().contains("@")) {
            return Optional.of(new CoreError("Email", "Email must contain @ symbol"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validatePassword(RegistrationRequest request) {
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            return Optional.of(new CoreError("Password", "Must not be empty"));
        } else if (request.getPassword().length() < 6) {
            return Optional.of(new CoreError("Password", "Password must be longer then 5 symbols"));
        }
        return Optional.empty();
    }
}