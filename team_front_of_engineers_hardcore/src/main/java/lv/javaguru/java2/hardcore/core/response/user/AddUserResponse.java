package lv.javaguru.java2.hardcore.core.response.user;

import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

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
