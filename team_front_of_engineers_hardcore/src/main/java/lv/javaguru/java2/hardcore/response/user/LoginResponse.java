package lv.javaguru.java2.hardcore.response.user;

import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.CoreResponse;

import java.util.List;

public class LoginResponse extends CoreResponse {

    private User user;


    public LoginResponse(User user) {
        this.user = user;
    }

    public LoginResponse(List<CoreError> errors) {
        super(errors);
    }

    public User getUser() {
        return user;
    }
}
