package lv.javaguru.java2.hrsystem.core.services.authorization;

import lv.javaguru.java2.hrsystem.core.database.ORMAuthorizationRepository;
import lv.javaguru.java2.hrsystem.core.domain.User;
import lv.javaguru.java2.hrsystem.core.requests.AuthorizeUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.AuthorizeUserResponse;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import lv.javaguru.java2.hrsystem.core.services.validators.user.AuthorizeUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorizeUserService {

    @Autowired
    private ORMAuthorizationRepository ormAuthorizationRepository;
    @Autowired
    private AuthorizeUserValidator validator;


    public AuthorizeUserResponse execute (AuthorizeUserRequest request){

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new AuthorizeUserResponse(errors);
        }
        Optional <User> authorization = ormAuthorizationRepository.
                authorizeUser(request.getEmail(), request.getPassword());

        return new AuthorizeUserResponse(authorization);

    }
}
