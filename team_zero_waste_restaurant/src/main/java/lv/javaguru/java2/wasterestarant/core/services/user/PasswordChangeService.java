package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.requests.user.PasswordChangeRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.user.PasswordChangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class PasswordChangeService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordChangeValidator validator;

    public PasswordChangeResponse execute(PasswordChangeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new PasswordChangeResponse(errors);
        }
        Optional<User> user = repository.findUserByEmail(request.getEmail()).stream().findFirst();
        User user1 = new User();
        return new PasswordChangeResponse(user1);
    }
}
