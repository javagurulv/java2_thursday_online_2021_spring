package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.AuthorizeUserValidator;
import lv.javaguru.java2.hrsystem.dependency_injection.DIComponent;
import lv.javaguru.java2.hrsystem.dependency_injection.DIDependency;
import lv.javaguru.java2.hrsystem.domain.User;

import java.util.*;

@DIComponent
public class AuthorizeUserService {

    @DIDependency private Database database;
    @DIDependency private AuthorizeUserValidator validator;

    public AuthorizeUserResponse execute (AuthorizeUserRequest request){

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AuthorizeUserResponse(errors);
        }
        Optional <User> authorization = database.authorizeUser(request.getEmail(), request.getPassword());

        return new AuthorizeUserResponse(authorization);

    }
}
