package lv.javaguru.java2.hrsystem.core.services.authorization;

import lv.javaguru.java2.hrsystem.core.database.ORMAuthorizationRepository;
import lv.javaguru.java2.hrsystem.core.domain.User;
import lv.javaguru.java2.hrsystem.core.requests.RegisterUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.responses.RegisterUserResponse;
import lv.javaguru.java2.hrsystem.core.services.validators.user.RegisterUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUserService {

    @Autowired
    private ORMAuthorizationRepository ormAuthorizationRepository;

    @Autowired
    private RegisterUserValidator validator;


    public RegisterUserResponse execute(RegisterUserRequest registrationRequest) {
        List<CoreError> errors = validator.validate(registrationRequest);

        if (!errors.isEmpty()) {
            return new RegisterUserResponse(errors);
        }

        User user = new User(registrationRequest.getUserRole(),
                registrationRequest.getFirstName(),
                registrationRequest.getSecondName(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword());

        ormAuthorizationRepository.registerUser(user);

        return new RegisterUserResponse(user);

    }
}
