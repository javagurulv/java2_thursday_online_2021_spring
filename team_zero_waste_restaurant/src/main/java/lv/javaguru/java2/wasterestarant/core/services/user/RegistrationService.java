package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.requests.user.RegistrationRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.user.RegistrationResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.validators.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static lv.javaguru.java2.wasterestarant.core.domain.UserRole.CLIENT;

@Component
public class RegistrationService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RegistrationValidator validator;

    public RegistrationResponse execute(RegistrationRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RegistrationResponse(errors);
        }
        User user = new User(CLIENT,
                            request.getName(),
                            request.getSurname(),
                            request.getEmail(),
                            request.getPassword());
        repository.save(user);
        return new RegistrationResponse(user);
    }
}
