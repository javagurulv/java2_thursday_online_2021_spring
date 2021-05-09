package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.User;

import java.util.*;

public class AuthorizeUserResponse extends CoreResponse{

    private Optional <User> authorization;

    public AuthorizeUserResponse(List<CoreError> errors) {
        super(errors);
    }

    public AuthorizeUserResponse(Optional<User> authorization) {
        this.authorization = authorization;
    }

    public Optional<User> getAuthorization() {
        return authorization;
    }

}
