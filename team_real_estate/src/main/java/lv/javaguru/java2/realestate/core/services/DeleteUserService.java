package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;
import lv.javaguru.java2.realestate.core.services.validators.DeleteUserValidator;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class DeleteUserService {
    @DIDependency
    private Database database;
    @DIDependency
    private DeleteUserValidator validator;

    public DeleteUserResponse execute(DeleteUserRequest deleteUserRequest) {
        List<CoreError> errors = validator.validate(deleteUserRequest);
        if (!errors.isEmpty()) {
            return new DeleteUserResponse(errors);
        }
        User user = new User(deleteUserRequest.getUsername(), deleteUserRequest.getPassword());
        boolean isUserDeleted = database.deleteUser(user);

        return new DeleteUserResponse(isUserDeleted);
    }
}

