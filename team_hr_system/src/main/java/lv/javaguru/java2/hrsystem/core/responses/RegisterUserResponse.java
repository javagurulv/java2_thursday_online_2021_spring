package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.User;

import java.util.List;

public class RegisterUserResponse extends CoreResponse{

    private User user;

    public RegisterUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public RegisterUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
