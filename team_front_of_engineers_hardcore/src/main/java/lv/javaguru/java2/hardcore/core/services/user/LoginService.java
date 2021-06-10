package lv.javaguru.java2.hardcore.core.services.user;


import lv.javaguru.java2.hardcore.consoleUI.UserSession;
import lv.javaguru.java2.hardcore.core.database.UserDatabase;
import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.requests.user.LoginRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.user.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LoginService {
    @Autowired
    private UserDatabase userDatabase;
    @Autowired
    private LoginValidator validator;
    @Autowired
    private UserSession userSession;



    public LoginResponse execute(LoginRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new LoginResponse(errors);
        }

        Optional<User> userOpt = userDatabase.getUserByLogin(request.getName());
        if (userOpt.isPresent()) {
        	User user = userOpt.get();

        	// password check

			userSession.setUserID(user.getUserId());
			userSession.setAuthorized(true);
			return new LoginResponse(user);
		} else {
        	CoreError error = new CoreError("login", "User not found!");
			List<CoreError> err = new ArrayList<>();
			err.add(error);
			return new LoginResponse(err);
		}
    }

}

