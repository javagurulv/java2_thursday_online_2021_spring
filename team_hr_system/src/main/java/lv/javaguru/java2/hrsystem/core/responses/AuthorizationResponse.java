package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.domain.User;

import java.util.List;
import java.util.Optional;

public class AuthorizationResponse extends CoreResponse{

    private Optional <User> authorization;

    public AuthorizationResponse(List<CoreError> errors) {
        super(errors);
    }

    public AuthorizationResponse(Optional<User> authorization) {
        this.authorization = authorization;
    }

    public Optional<User> getAuthorization() {
        return authorization;
    }

}
