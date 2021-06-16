package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.CreateUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateUserResponse;
import lv.javaguru.java2.realestate.core.services.validators.CreateUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CreateUserValidator validator;

    public CreateUserResponse execute(CreateUserRequest createUserRequest) {
        List<CoreError> errors = validator.validate(createUserRequest);
        if (!errors.isEmpty()) {
            return new CreateUserResponse(errors);
        }

        User user = new User(
                createUserRequest.getUsername(),
                createUserRequest.getPassword());

        userRepository.createAccount(user);
        return new CreateUserResponse(user);
    }
}
