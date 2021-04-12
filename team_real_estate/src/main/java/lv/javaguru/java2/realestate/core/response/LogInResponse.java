package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.User;

public class LogInResponse {
    private final User user;

    public LogInResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
