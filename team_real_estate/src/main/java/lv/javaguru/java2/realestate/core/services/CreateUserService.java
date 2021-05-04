package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;
import lv.javaguru.java2.realestate.core.services.validators.CreateUserValidator;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class CreateUserService {
    @DIDependency
    private Database database;
    @DIDependency
    private CreateUserValidator validator;

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
