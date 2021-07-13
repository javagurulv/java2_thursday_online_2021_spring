package lv.javaguru.java2.hardcore.core.services.user;


import lv.javaguru.java2.hardcore.core.database.UserRepository;

import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.requests.user.AddUserRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.user.AddUserResponse;
import lv.javaguru.java2.hardcore.core.services.user.validators.AddUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class AddUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddUserValidator validator;


    public AddUserResponse execute(AddUserRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddUserResponse(errors);
        } else {
            User user = new User(request.getName(), request.getPassword());
            userRepository.addUser(user);
            Optional<User> userOpt = userRepository.getUserByLogin(request.getName());
            return new AddUserResponse(userOpt.get());
        }
    }
}
