package lv.javaguru.java2.wasterestarant.core.responses.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class LoginResponse extends CoreResponse {
    private User user;
    private boolean isLoggedIn = false;

    public LoginResponse(List<CoreError> errors) {
        super(errors);
    }

    public LoginResponse() {

    }

    public LoginResponse(User user, boolean isLoggedIn) {
        this.user = user;
        this.isLoggedIn = isLoggedIn;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public User getUser() {
        return user;
    }
}
