package lv.javaguru.java2.hardcore.services.user;


import lv.javaguru.java2.hardcore.database.UserDatabase;

import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.user.AddUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
            return new AddUserResponse(user);
        }
    }
}
