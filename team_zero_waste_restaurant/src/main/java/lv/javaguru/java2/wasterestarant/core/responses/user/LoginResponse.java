package lv.javaguru.java2.wasterestarant.core.responses.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;
import java.util.Optional;

public class LoginResponse extends CoreResponse {
    private User user;

    public LoginResponse(List<CoreError> errors) {
        super(errors);
    }

    public LoginResponse() {
    }

    public LoginResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
