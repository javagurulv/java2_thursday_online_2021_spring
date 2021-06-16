package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.validators.LogInValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogInService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LogInValidator validator;

    public LogInResponse execute(LogInRequest logInRequest) {
        List<CoreError> errors = validator.validate(logInRequest);
        if (!errors.isEmpty()) {
            return new LogInResponse(errors);
        }
        User user = new User(
                logInRequest.getUsername(),
                logInRequest.getPassword());
        if (userRepository.logIn(user)) {
            return new LogInResponse(user, true);
        } else {
            return new LogInResponse();
        }
    }
}
