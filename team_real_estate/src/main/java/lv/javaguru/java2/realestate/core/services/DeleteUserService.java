package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;

import java.util.List;

public class DeleteUserService {
    private final Database database;
    private final DeleteUserValidator validator;

    public DeleteUserService(Database database, DeleteUserValidator validator) {
        this.database = database;
        this.validator = validator;
    }

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

