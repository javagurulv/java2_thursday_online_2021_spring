package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.domain.User;

import java.util.List;

public class RegistrationResponse extends CoreResponse{

    private User user;

    public RegistrationResponse(List<CoreError> errors) {
        super(errors);
    }

    public RegistrationResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
