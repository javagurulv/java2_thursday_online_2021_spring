package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangePasswordRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ChangePasswordValidator {
    @Autowired
    private UserRepository repository;

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(ChangePasswordRequest request) {
        validateEmail(request).ifPresent(errors::add);
        return errors;
    }
    private Optional<CoreError> validateEmail(ChangePasswordRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("E-mail", "Must not be empty"));
        } else if (!request.getEmail().contains("@")) {
            return Optional.of(new CoreError("E-mail", "Must contain @ symbol"));
        } else if (repository.findUserByEmail(request.getEmail()).size() < 1) {
            return Optional.of(new CoreError("User with e-mail", request.getEmail() + " is not found!"));
        }
        return Optional.empty();
    }
}
