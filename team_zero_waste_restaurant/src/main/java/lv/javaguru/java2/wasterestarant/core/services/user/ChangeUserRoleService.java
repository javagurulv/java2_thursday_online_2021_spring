package lv.javaguru.java2.wasterestarant.core.services.user;

import lv.javaguru.java2.wasterestarant.core.database.user.UserRepository;
import lv.javaguru.java2.wasterestarant.core.requests.user.ChangeUserRoleRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.user.ChangeUserRoleResponse;
import lv.javaguru.java2.wasterestarant.core.services.user.validators.ChangeUserRoleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ChangeUserRoleService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ChangeUserRoleValidator validator;

    public ChangeUserRoleResponse execute(ChangeUserRoleRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new ChangeUserRoleResponse(errors);
        }
        return new ChangeUserRoleResponse(repository.changeUserRole(request.getUserRole(), request.getEmail()));
    }

}
