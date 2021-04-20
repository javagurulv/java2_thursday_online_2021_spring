package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.Database;
import lv.javaguru.java2.hrsystem.core.requests.LoginRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.LoginResponse;

import java.util.List;

public class LoginService {

    private Database database;
    private LoginValidator validator;

    public LoginService(Database database, LoginValidator validator) {

        this.database = database;
        this.validator = validator;

    }

    public LoginResponse execute (LoginRequest loginRequest){

        List<CoreError> errors = validator.validate(loginRequest);

        if (!errors.isEmpty()) {
            return new LoginResponse(errors);
        }

        boolean login = database.loginAdm(loginRequest.getEmail(), loginRequest.getPassword());

        return new LoginResponse(login);

    }
}
