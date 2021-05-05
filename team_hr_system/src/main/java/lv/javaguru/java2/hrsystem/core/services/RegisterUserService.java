package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.RegisterUserResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.RegisterUserValidator;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;
import lv.javaguru.java2.hrsystem.domain.User;

import java.util.List;

@DIComponent
public class RegisterUserService {

    @DIDependency
    private Database database;

    @DIDependency
    private RegisterUserValidator validator;

   /* public RegisterUserService(Database database, RegisterUserValidator validator) {

        this.database = database;
        this.validator = validator;

    }*/

    public RegisterUserResponse execute(RegisterUserRequest registrationRequest) {
        List<CoreError> errors = validator.validate(registrationRequest);

        if (!errors.isEmpty()) {
            return new RegisterUserResponse(errors);
        }

        User user = new User(registrationRequest.getUserRole(),
                registrationRequest.getFirstName(),
                registrationRequest.getSecondName(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword());

        database.registerUser(user);

        return new RegisterUserResponse(user);

    }
}
