package lv.javaguru.java2.wasterestarant.core.responses.user;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class LoginResponse extends CoreResponse {
    List<User> users;

    public LoginResponse(List<User> users, List<CoreError> errors) {
        super(errors);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
