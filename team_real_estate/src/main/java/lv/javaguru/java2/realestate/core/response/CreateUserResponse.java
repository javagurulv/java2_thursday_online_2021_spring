package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.User;

import java.util.List;

public class CreateUserResponse extends CoreResponse {

    private User user;

    public CreateUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public CreateUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
