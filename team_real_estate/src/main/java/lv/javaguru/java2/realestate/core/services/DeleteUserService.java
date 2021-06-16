package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.DeleteUserRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.DeleteUserResponse;
import lv.javaguru.java2.realestate.core.services.validators.DeleteUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeleteUserValidator validator;

    public DeleteUserResponse execute(DeleteUserRequest deleteUserRequest) {
        List<CoreError> errors = validator.validate(deleteUserRequest);
        if (!errors.isEmpty()) {
            return new DeleteUserResponse(errors);
        }
        User user = new User(deleteUserRequest.getUsername(), deleteUserRequest.getPassword());
        boolean isUserDeleted = userRepository.deleteUser(user);

        return new DeleteUserResponse(isUserDeleted);
    }
}

