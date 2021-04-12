package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.User;

public class CreateUserResponse {

    private final User user;

    public CreateUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
