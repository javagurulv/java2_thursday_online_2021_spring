package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangeUserRoleRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ChangeUserRoleValidator {

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(ChangeUserRoleRequest request) {
        validateUserRole(request).ifPresent(errors::add);
        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateUserRole(ChangeUserRoleRequest request) {
        if (request == null) {
            return Optional.of(new CoreError("User role", "Must not be empty"));
        } else if (!request.getUserRole().equals(UserRole.ADMIN)) {
            return Optional.of(new CoreError("User role", "You don't have rights to change user role"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateEmail(ChangeUserRoleRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("Email", "Must not be empty"));
        } else if (!request.getEmail().contains("@")) {
            return Optional.of(new CoreError("Email", "Email must contain @ symbol"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validatePassword(ChangeUserRoleRequest request) {
        return (request.getPassword() == null || request.getPassword().isEmpty())
                ? Optional.of(new CoreError("Password", "Must not be empty"))
                : Optional.empty();
    }
}
