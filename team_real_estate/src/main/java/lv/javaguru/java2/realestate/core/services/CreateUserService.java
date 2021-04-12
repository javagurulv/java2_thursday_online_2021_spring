package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;

public class CreateUserService {
    Database database;

    public CreateUserService(Database database) {
        this.database = database;
    }

    public CreateUserResponse execute(CreateUserRequest createUserRequest){
        User user = new User(
                createUserRequest.getUsername(),
                createUserRequest.getPassword());

        database.createAccount(user);
        return new CreateUserResponse(user);
    }
}
