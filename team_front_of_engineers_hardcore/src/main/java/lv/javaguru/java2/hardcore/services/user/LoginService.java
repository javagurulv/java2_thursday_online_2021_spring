package lv.javaguru.java2.hardcore.services.user;


import lv.javaguru.java2.hardcore.database.UserDatabase;

import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.user.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class LoginService {
    @Autowired
    private UserDatabase userDatabase;
    @Autowired
    private LoginValidator validator;



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

