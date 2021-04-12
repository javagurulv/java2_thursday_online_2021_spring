package lv.javaguru.java2.realestate.services;

import lv.javaguru.java2.realestate.database.Database;
import lv.javaguru.java2.realestate.domain.User;
import lv.javaguru.java2.realestate.requests.CreateAccountRequest;
import lv.javaguru.java2.realestate.response.CreateAccountResponse;

public class CreateAccountService {
    Database database;

    public CreateAccountService(Database database) {
        this.database = database;
    }

    public CreateAccountResponse execute(CreateAccountRequest createAccountRequest){
        User user = new User(
                createAccountRequest.getUsername(),
                createAccountRequest.getPassword());

        database.createAccount(user);
        return new CreateAccountResponse(user);
    }
}
