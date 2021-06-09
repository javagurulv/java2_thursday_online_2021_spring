package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.requests.user.LoginRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.user.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private LoginValidator validator;

    public LoginResponse execute(LoginRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new LoginResponse(null, errors);
        }
        List<User> users = isUserRegistered(request);

        return new LoginResponse(users, null);
    }

    private List<User> isUserRegistered(LoginRequest request){
        List<User> users = new ArrayList<>();
        if(request.isNameProvided() && request.isPasswordProvided()){
            repository.findUserByNameAndPassword(request.getName(), request.getPassword());
        }
        return users;
    }

}
