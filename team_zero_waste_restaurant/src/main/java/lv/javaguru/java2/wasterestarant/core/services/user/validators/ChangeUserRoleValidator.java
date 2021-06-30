package lv.javaguru.java2.wasterestarant.core.services.user.validators;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangeUserRoleRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ChangeUserRoleValidator {
    @Autowired
    private UserRepository repository;

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(ChangeUserRoleRequest request) {
        validateUserRole(request).ifPresent(errors::add);
        validateEmail(request).ifPresent(errors::add);
        if(errors.isEmpty()) {
            validateRegistration(request).ifPresent(errors::add);
        }
        return errors;
    }

    private Optional<CoreError> validateUserRole(ChangeUserRoleRequest request) {
        return (request.getUserRole() == null)
                ? Optional.of(new CoreError("User role", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateEmail(ChangeUserRoleRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("E-mail", "Must not be empty"));
        } else if (!request.getEmail().contains("@")) {
            return Optional.of(new CoreError("E-mail", "Must contain @ symbol"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validateRegistration(ChangeUserRoleRequest request) {
        return (!repository.isEmailRegistered(request.getEmail()))
                ? Optional.of(new CoreError("E-mail", request.getEmail() + " is not registered in the system!"))
                : Optional.empty();
    }
}
