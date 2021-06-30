package lv.javaguru.java2.wasterestarant.core.services.user.validators;

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
        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        if(errors.isEmpty()) {
            validateUserRegistration(request).ifPresent(errors::add);
        }
        return errors;
    }

    private Optional<CoreError> validateEmail(LoginRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("Email", "Must not be empty"));
        }else if (!request.getEmail().contains("@")) {
            return Optional.of(new CoreError("Email", "Email must contain @ symbol"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validatePassword(LoginRequest request) {
        return (request.getPassword() == null || request.getPassword().isEmpty())
                ? Optional.of(new CoreError("Password", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateUserRegistration(LoginRequest request){
        return !(repository.isUserRegistered(request.getEmail(), request.getPassword()))
                ? Optional.of(new CoreError("Email and Password", "User is not found!"))
                : Optional.empty();
    }
}
