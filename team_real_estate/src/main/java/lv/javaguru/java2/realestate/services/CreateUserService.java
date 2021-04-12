package lv.javaguru.java2.realestate.services;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.domain.User;
import lv.javaguru.java2.realestate.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.response.CreateUserResponse;

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
