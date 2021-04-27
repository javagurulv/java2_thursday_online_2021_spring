package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.AuthorizationRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.AuthorizationResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.AuthorizationValidator;
import lv.javaguru.java2.hrsystem.domain.User;

import java.util.List;
import java.util.Optional;

public class AuthorizationService {

    private Database database;
    private AuthorizationValidator validator;

    public AuthorizationService(Database database, AuthorizationValidator validator) {

        this.database = database;
        this.validator = validator;

    }

    public AuthorizationResponse execute (AuthorizationRequest request){

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AuthorizationResponse(errors);
        }
        Optional <User> authorization = database.authorization(request.getEmail(), request.getPassword());

        return new AuthorizationResponse(authorization);

    }
}
