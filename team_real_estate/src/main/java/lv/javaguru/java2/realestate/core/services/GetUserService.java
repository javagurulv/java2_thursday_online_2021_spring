package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.user.UserRepository;
import lv.javaguru.java2.realestate.core.domain.User;
import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.requests.GetUserRequest;
import lv.javaguru.java2.realestate.core.requests.LogInRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;
import lv.javaguru.java2.realestate.core.response.GetUserResponse;
import lv.javaguru.java2.realestate.core.response.LogInResponse;
import lv.javaguru.java2.realestate.core.services.validators.GetUserValidator;
import lv.javaguru.java2.realestate.core.services.validators.LogInValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GetUserValidator validator;

    public GetUserResponse execute(GetUserRequest getUserRequest) {
        List<CoreError> errors = validator.validate(getUserRequest);
        if (!errors.isEmpty()) {
            return new GetUserResponse(errors);
        }
        User user = new User(
                getUserRequest.getUsername(),
                getUserRequest.getPassword());
        User responseUser = userRepository.getUser(user);
        return new GetUserResponse(responseUser);
    }
}
