package lv.javaguru.java2.hardcore.core.services.user;


import lv.javaguru.java2.hardcore.consoleUI.UserSession;
import lv.javaguru.java2.hardcore.core.database.UserRepository;
import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.user.LoginResponse;
import lv.javaguru.java2.hardcore.core.services.user.validators.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginValidator validator;
    @Autowired
    private UserSession userSession;


    public LoginResponse execute(LoginRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new LoginResponse(errors);
        }
        return userRepository.getUserByLogin(request.getName())
				.map(user -> checkUserCredentials(request, user))
				.orElseGet(this::buildUserNotFoundResponse);
    }

	private LoginResponse buildUserNotFoundResponse() {
		CoreError error = new CoreError("Username", "There's no such user in database");
		List<CoreError> err = new ArrayList<>();
		err.add(error);
		return new LoginResponse(err);
	}

	private LoginResponse checkUserCredentials(LoginRequest request,
											   User user) {
		if (user.getPassword().equals(request.getPassword())) {
			return authorizeUserAndBuildSuccessResponse(user);
		} else {
			return buildIncorrectUserPasswordResponse();
		}
	}

	private LoginResponse authorizeUserAndBuildSuccessResponse(User user) {
		userSession.setUserID(user.getUserId());
		userSession.setAuthorized(true);
		System.out.println("Welcome "+ user.getName());
		System.out.println(user);
		return new LoginResponse(user);
	}

	private LoginResponse buildIncorrectUserPasswordResponse() {
		CoreError error = new CoreError("Password", "Password is incorrect");
		List<CoreError> err = new ArrayList<>();
		err.add(error);
		return new LoginResponse(err);
	}

}

