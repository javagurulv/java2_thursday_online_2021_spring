package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.User;

import java.util.List;

public class LogInResponse extends CoreResponse {
    private User user;

    public LogInResponse(List<CoreError> errors) {
        super(errors);
    }

    public LogInResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
