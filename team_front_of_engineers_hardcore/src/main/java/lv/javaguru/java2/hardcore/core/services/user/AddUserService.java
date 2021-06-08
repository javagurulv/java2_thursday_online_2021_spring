package lv.javaguru.java2.hardcore.core.services.user;


import lv.javaguru.java2.hardcore.core.database.UserDatabase;

import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.user.AddUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AddUserService {
    @Autowired
    private UserDatabase userDatabase;
    @Autowired
    private AddUserValidator validator;


    public AddUserResponse execute(AddUserRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddUserResponse(errors);
        } else {
            User user = new User(request.getName(), request.getPassword());
            userDatabase.addUser(user);
            Optional<User> userOpt = userDatabase.getUserByLogin(request.getName());
            return new AddUserResponse(userOpt.get());
        }
    }
}
