package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.LogInResponse;

public class LogInService {

    Database database;

    public LogInService(Database database) {
        this.database = database;
    }

    public LogInResponse execute(LogInRequest logInRequest){
        User user = new User(
                logInRequest.getUsername(),
                logInRequest.getPassword());
        database.logIn(user);
        return new LogInResponse(user);
    }
}
