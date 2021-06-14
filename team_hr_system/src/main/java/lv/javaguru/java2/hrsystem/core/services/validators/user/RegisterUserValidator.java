package lv.javaguru.java2.hrsystem.core.services.validators.user;

import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegisterUserValidator {

    public List<CoreError> validate (RegisterUserRequest request){
        List<CoreError> errors = new ArrayList<>();
        validateUserRole(request).ifPresent(errors::add);
        validateFirstName(request).ifPresent(errors::add);
        validateSecondName(request).ifPresent(errors::add);
        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateUserRole(RegisterUserRequest request){
        return (request.getUserRole() == null
                ? Optional.of(new CoreError("user role", "Must not be empty!"))
                : Optional.empty());
    }

    private Optional<CoreError> validateFirstName(RegisterUserRequest request) {
        return (request.getFirstName() == null || request.getFirstName().isEmpty())
                ? Optional.of(new CoreError("first name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateSecondName(RegisterUserRequest request) {
        return (request.getSecondName() == null || request.getSecondName().isEmpty())
                ? Optional.of(new CoreError("second name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateEmail(RegisterUserRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {

            return Optional.of(new CoreError("email", "Must not be empty!"));

        } else if (request.getEmail().matches("^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$")) {

            return Optional.of(new CoreError("email", "Wrong format!"));

        } else {

            return Optional.empty();

        }
    }

    private Optional<CoreError> validatePassword(RegisterUserRequest request) {
        if (request.getPassword() == null || request.getPassword().isEmpty()){

           return Optional.of(new CoreError("password", "Must not be empty!"));

        } else if (request.getPassword().length() < 6){

            return Optional.of(new CoreError("password", "Must not be short!"));

        } else if (request.getPassword().matches("^[0-9]*$") ||
                request.getPassword().matches("^[a-zA-Z]*$")) {

            return Optional.of(new CoreError("password", "Must not contain only numbers or letters!"));

        } else if (request.getPassword().matches("(?=\\S+$)")) {

            return Optional.of(new CoreError("password", "Must not contain space!"));

        } else

            return Optional.empty();

    }
}
