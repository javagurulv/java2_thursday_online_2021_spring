package lv.javaguru.java2.hardcore.services.user;


import lv.javaguru.java2.hardcore.database.UserDatabase;
import lv.javaguru.java2.hardcore.datamodels.User;
import lv.javaguru.java2.hardcore.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.user.LoginResponse;

import java.util.List;

public class LoginService {

    private UserDatabase userDatabase;
    private LoginValidator validator;


    public LoginService(UserDatabase userDatabase, LoginValidator validator) {
        this.userDatabase = userDatabase;
        this.validator = validator;
    }

    public LoginResponse execute(LoginRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new LoginResponse(errors);
        }
            User user = new User(request.getName(), request.getPassword());
            userDatabase.logIn(user);
            return new LoginResponse(user);

    }

}

