package lv.javaguru.java2.wasterestarant.core.responses.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class RegistrationResponse extends CoreResponse {
    private User newUser;

    public RegistrationResponse(List<CoreError> errors) {
        super(errors);
    }

    public RegistrationResponse(User newUser) {
        this.newUser = newUser;
    }

    public User getNewUser() {
        return newUser;
    }
}
