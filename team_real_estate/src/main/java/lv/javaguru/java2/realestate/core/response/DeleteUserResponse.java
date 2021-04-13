package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.User;

import java.util.List;

public class DeleteUserResponse extends CoreResponse {
    private User user;

    public DeleteUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
