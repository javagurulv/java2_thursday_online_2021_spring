package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.LoginRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginValidator {
    public List<CoreError> validate (LoginRequest request) {
        List<CoreError> errors = new ArrayList<>();

        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);

        return errors;
    }

    private Optional<CoreError> validateEmail(LoginRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {

            return Optional.of(new CoreError("email", "Must not be empty!"));

        } else {

            return Optional.empty();

        }
    }

    private Optional<CoreError> validatePassword(LoginRequest request) {
        if (request.getPassword() == null || request.getPassword().isEmpty()){

            return Optional.of(new CoreError("password", "Must not be empty!"));

        } else {

            return Optional.empty();

        }
    }
}
