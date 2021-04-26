package lv.javaguru.java2.hardcore.response.user;

import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.CoreResponse;

import java.util.List;

public class AddUserResponse extends CoreResponse {

    private User newUser;

    public AddUserResponse(User newUser) {
        this.newUser = newUser;
    }

    public AddUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public User getNewUser() {
        return newUser;
    }
}
