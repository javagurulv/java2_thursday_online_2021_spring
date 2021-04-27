package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.validators.LogInValidator;

import java.util.List;

public class LogInService {

    private final Database database;
    private final LogInValidator validator;

    public LogInService(Database database, LogInValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public LogInResponse execute(LogInRequest logInRequest) {
        List<CoreError> errors = validator.validate(logInRequest);
        if (!errors.isEmpty()) {
            return new LogInResponse(errors);
        }
        User user = new User(
                logInRequest.getUsername(),
                logInRequest.getPassword());
        if (database.logIn(user)) {
            return new LogInResponse(user, true);
        } else {
            return new LogInResponse();
        }
    }
}
