package lv.javaguru.java2.hardcore.core.services.user;


import lv.javaguru.java2.hardcore.core.database.UserDatabase;
import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.user.LoginResponse;
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

