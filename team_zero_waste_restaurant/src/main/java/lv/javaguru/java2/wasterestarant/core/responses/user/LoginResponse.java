package lv.javaguru.java2.wasterestarant.core.responses.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;
import java.util.Optional;

public class LoginResponse extends CoreResponse {
    Optional<User> user;

    public LoginResponse(Optional <User> user, List<CoreError> errors) {
        super(errors);
        this.user = user;
    }

    public Optional<User> getUser() {
        return user;
    }
}
