package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;

public class DeleteUserService {
    Database database;

    public DeleteUserService(Database database) {
        this.database = database;
    }

    public DeleteUserResponse execute(DeleteUserRequest deleteUserRequest) {
        User user = new User(deleteUserRequest.getUsername(), deleteUserRequest.getPassword());
        database.deleteUser(user);
        return new DeleteUserResponse(user);
    }
}
