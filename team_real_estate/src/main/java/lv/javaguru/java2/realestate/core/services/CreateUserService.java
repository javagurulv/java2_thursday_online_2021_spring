package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;
import lv.javaguru.java2.realestate.core.services.validators.CreateUserValidator;

import java.util.List;

public class CreateUserService {
    private final Database database;
    private final CreateUserValidator validator;

    public CreateUserService(Database database, CreateUserValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public CreateUserResponse execute(CreateUserRequest createUserRequest) {
        List<CoreError> errors = validator.validate(createUserRequest);
        if (!errors.isEmpty()) {
            return new CreateUserResponse(errors);
        }

        User user = new User(
                createUserRequest.getUsername(),
                createUserRequest.getPassword());

        database.createAccount(user);
        return new CreateUserResponse(user);
    }
}
