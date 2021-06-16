package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RegistrationValidator {
    List<CoreError> errors = new ArrayList<>();

    public List<CoreError> validate(RegistrationRequest request) {
        validateName(request).ifPresent(errors::add);
        validateSurname(request).ifPresent(errors::add);
        validatePersonal_Code(request).ifPresent(errors::add);
        validateEmail(request).ifPresent(errors::add);
        validatePassword(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateName(RegistrationRequest request) {
        return (request.getName() == null || request.getName().isEmpty())
                ? Optional.of(new CoreError("Name", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validateSurname(RegistrationRequest request) {
        return (request.getSurname() == null || request.getSurname().isEmpty())
                ? Optional.of(new CoreError("Surname", "Must not be empty"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePersonal_Code(RegistrationRequest request) {

        if (request.getPersonal_code() == null || request.getPersonal_code().isEmpty()) {
                return Optional.of(new CoreError("Personal code", "Must not be empty")); }
        else if(request.getPersonal_code().length() < 12) {
            return Optional.of(new CoreError("Personal code", "Must be 12 characters long"));
        }
        else if(request.getPersonal_code().length() > 12) {
            return Optional.of(new CoreError("Personal code", "Must be 12 characters long"));
        }
        else if(!request.getPersonal_code().contains("-")) {
            return Optional.of(new CoreError("Personal code", "Must contain '-' "));
        }

                return Optional.empty();
    }

    private Optional<CoreError> validateEmail(RegistrationRequest request) {
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return Optional.of(new CoreError("Email", "Must not be empty"));
        } else if (!request.getEmail().contains("@")) {
            return Optional.of(new CoreError("Email", "Email must contain @ symbol"));
        }
        return Optional.empty();
    }

    private Optional<CoreError> validatePassword(RegistrationRequest request) {
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            return Optional.of(new CoreError("Password", "Must not be empty"));
        } else if (request.getPassword().length() < 6) {
            return Optional.of(new CoreError("Password", "Password must be longer then 5 symbols"));
        }
        return Optional.empty();
    }
}