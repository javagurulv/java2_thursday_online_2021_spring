package lv.javaguru.java2.hrsystem.core.services.validators.user;

import lv.javaguru.java2.hrsystem.core.database.ORMUserRepository;
import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorizeUserValidator {

    @Autowired ORMUserRepository ormUserRepository;

    public List<CoreError> validate (AuthorizeUserRequest request) {
        List<CoreError> errors = new ArrayList<>();

        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        validateInputEmailOrPassword(request).ifPresent(errors::add);

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

    private Optional<CoreError> validateInputEmailOrPassword(AuthorizeUserRequest request) {
        if (ormUserRepository.getAllUsers().stream().
                filter(user -> user.getEmail().equals(request.getEmail())
                        && user.getPassword().equals(request.getPassword()))
                .findFirst()
                .isEmpty()) {
            return Optional.of(new CoreError("email or password", "is incorrect!"));
        } else {
            return Optional.empty();
        }
    }
}
