package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.LoginRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LoginValidator {
    @Autowired
    private UserRepository repository;

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(LoginRequest request) {
        errors.addAll(validateEmail(request));
        validatePassword(request).ifPresent(errors::add);
        validateUserRegistration(request).ifPresent(errors::add);
        return errors;
    }

    private List<CoreError> validateEmail(LoginRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            errors.add(new CoreError("Email", "Must not be empty"));
        } if (!request.getEmail().contains("@")) {
            errors.add(new CoreError("Email", "Email must contain @ symbol"));
        }
        return errors;
    }

    private Optional<CoreError> validatePassword(LoginRequest request) {
        return (request.getPassword() == null || request.getPassword().isEmpty())
                ? Optional.of(new CoreError("Password", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateUserRegistration(LoginRequest request){
        return !(repository.isUserRegistered(request.getEmail(), request.getPassword()))
                ? Optional.of(new CoreError("Email and Password", "User is not registered!"))
                : Optional.empty();
    }
}
