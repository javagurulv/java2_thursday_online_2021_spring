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
        errors.addAll(validateEmail(request));
        return errors;
    }
    private List<CoreError> validateEmail(ChangePasswordRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            errors.add(new CoreError("E-mail", "Must not be empty"));
        } if (!request.getEmail().contains("@")) {
            errors.add(new CoreError("E-mail", "Must contain @ symbol"));
        } if (!repository.isEmailRegistered(request.getEmail())) {
            errors.add(new CoreError("E-mail", request.getEmail() + " is not found!"));
        }
        return errors;
    }
}
