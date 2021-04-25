package lv.javaguru.java2.hardcore.services.user;


import lv.javaguru.java2.hardcore.database.UserDatabase;
import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.user.AddUserResponse;

import java.util.List;

public class AddUserService {

    private UserDatabase userDatabase;
    private AddUserValidator validator;

    public AddUserService(UserDatabase userDatabase, AddUserValidator validator) {
        this.userDatabase = userDatabase;
        this.validator = validator;
    }

    public AddUserResponse execute(AddUserRequest request){
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new AddUserResponse(errors);
        }else {
            User user = new User(request.getName(),request.getPassword());
            userDatabase.addUser(user);
            return new AddUserResponse(user);
        }
    }
}
