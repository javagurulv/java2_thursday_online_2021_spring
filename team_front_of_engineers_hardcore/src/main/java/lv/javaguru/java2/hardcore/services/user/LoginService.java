package lv.javaguru.java2.hardcore.services.user;


import lv.javaguru.java2.hardcore.database.UserDatabase;
import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.user.LoginResponse;

import java.util.List;

public class LoginService {

    private UserDatabase userDatabase;
    private LoginValidator validator;
    private User user;
    private Long userID;


    public LoginService(UserDatabase userDatabase, LoginValidator validator) {
        this.userDatabase = userDatabase;
        this.validator = validator;
    }

    public LoginResponse execute(LoginRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new LoginResponse(errors);
        }
            user = new User(request.getName(), request.getPassword());
            userID=userDatabase.getUserId();
            userDatabase.logIn(user);
            return new LoginResponse(user);


    }

    public User getCurrentUser() {
        return user;
    }

    public Long getCurrentUserID() {
        return userID;
    }
}

