package lv.javaguru.java2.realestate.response;

import lv.javaguru.java2.realestate.domain.User;

public class CreateAccountResponse {

    private final User user;

    public CreateAccountResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
