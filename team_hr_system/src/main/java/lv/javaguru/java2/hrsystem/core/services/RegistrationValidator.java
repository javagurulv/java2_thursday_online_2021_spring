package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.requests.RegistrationRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RegistrationValidator {

    public List<CoreError> validate (RegistrationRequest request){
        List<CoreError> errors = new ArrayList<>();
        validateFirstName(request).ifPresent(errors::add);
        validateSecondName(request).ifPresent(errors::add);
        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateFirstName(RegistrationRequest request) {
        return (request.getFirstName() == null || request.getFirstName().isEmpty())
                ? Optional.of(new CoreError("first name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateSecondName(RegistrationRequest request) {
        return (request.getSecondName() == null || request.getSecondName().isEmpty())
                ? Optional.of(new CoreError("second name", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateEmail(RegistrationRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {

            return Optional.of(new CoreError("email", "Must not be empty!"));

        } else if (request.getEmail().regionMatches(request.getEmail().length() - 11, "@gmail.com", 0, 10) ||
                request.getEmail().regionMatches(request.getEmail().length() - 9, "@mail.ru", 0, 8) ||
                request.getEmail().regionMatches(request.getEmail().length() - 9, "@list.ru", 0, 8)) {

            return Optional.of(new CoreError("email", "Wrong format!"));

        } else {

            return Optional.empty();

        }
    }

    private Optional<CoreError> validatePassword(RegistrationRequest request) {
        if (request.getPassword() == null || request.getPassword().isEmpty()){

           return Optional.of(new CoreError("password", "Must not be empty!"));

        } else if (request.getPassword().length() < 6){

            return Optional.of(new CoreError("password", "Must not be short!"));

        } else if (request.getPassword().matches(".*[0-9]+.*") ||
                request.getPassword().matches(".*[a-zA-Z]+.*")) {

            return Optional.of(new CoreError("password", "Must not contain only numbers or letters!"));

        } else {

            return Optional.empty();

        }
    }
}
