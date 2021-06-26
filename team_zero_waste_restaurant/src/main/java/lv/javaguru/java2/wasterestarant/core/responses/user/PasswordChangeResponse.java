package lv.javaguru.java2.wasterestarant.core.responses.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class PasswordChangeResponse extends CoreResponse {
    private User user;

    public PasswordChangeResponse(List<CoreError> errors) {
        super(errors);
    }

    public PasswordChangeResponse(User user) {
        this.user = user;
    }
}
