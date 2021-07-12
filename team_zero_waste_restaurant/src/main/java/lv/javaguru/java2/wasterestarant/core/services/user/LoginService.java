package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.requests.user.LoginRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.user.LoginResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.validators.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class LoginService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private LoginValidator validator;

    public LoginResponse execute(LoginRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new LoginResponse(errors);
        }
        User loginUser = repository.findUserByEmailAndPassword(request.getEmail(), request.getPassword());
        if (loginUser == null) {
            errors.add(new CoreError("E-mail and Password", "User not found"));
            return new LoginResponse(errors);
        } else {
            return new LoginResponse(loginUser);
        }
    }
}
