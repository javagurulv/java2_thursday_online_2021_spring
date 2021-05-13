package lv.javaguru.java2.hardcore.core.response.user;

import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

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
