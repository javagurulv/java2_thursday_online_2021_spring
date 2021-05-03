package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.validators.LogInValidator;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class LogInService {
    @DIDependency
    private Database database;
    @DIDependency
    private LogInValidator validator;

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
