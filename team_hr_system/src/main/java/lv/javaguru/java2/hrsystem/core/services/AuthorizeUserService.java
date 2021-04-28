package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.AuthorizeUserResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.AuthorizeUserValidator;
import lv.javaguru.java2.hrsystem.domain.User;

import java.util.*;

public class AuthorizeUserService {

    private Database database;
    private AuthorizeUserValidator validator;

    public AuthorizeUserService(Database database, AuthorizeUserValidator validator) {

        this.database = database;
        this.validator = validator;

    }

    public AuthorizeUserResponse execute (AuthorizeUserRequest request){

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AuthorizeUserResponse(errors);
        }
        Optional <User> authorization = database.authorizeUser(request.getEmail(), request.getPassword());

        return new AuthorizeUserResponse(authorization);

    }
}
