package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegistrationValidator {
    @Autowired
    private UserRepository repository;

    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(RegistrationRequest request) {
        validateName(request).ifPresent(errors::add);
        validateSurname(request).ifPresent(errors::add);
        errors.addAll(validateEmail(request));
        errors.addAll(validatePassword(request));
        return errors;
    }

    private Optional<CoreError> validateName(RegistrationRequest request) {
        return (request.getFirstName() == null || request.getFirstName().isEmpty())
                ? Optional.of(new CoreError("Name", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateSurname(RegistrationRequest request) {
        return (request.getSecondName() == null || request.getSecondName().isEmpty())
                ? Optional.of(new CoreError("Surname", "Must not be empty"))
                : Optional.empty();
    }


    private List<CoreError> validateEmail(RegistrationRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            errors.add(new CoreError("E-mail", "Must not be empty"));
        } if (!request.getEmail().contains("@")) {
            errors.add(new CoreError("E-mail", "Must contain @ symbol"));
        } if (repository.isEmailRegistered(request.getEmail())) {
            errors.add(new CoreError("E-mail", request.getEmail() + " is already taken!"));
        }
        return errors;
    }

    private List<CoreError> validatePassword(RegistrationRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            errors.add(new CoreError("Password", "Must not be empty"));
        } if (request.getPassword().length() < 5) {
            errors.add(new CoreError("Password", "Must be at least 5 symbols"));
        }
        return errors;
    }
}