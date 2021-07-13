package lv.javaguru.java2.hrsystem.core.services.user;

import lv.javaguru.java2.hrsystem.core.database.ORMUserRepository;
import lv.javaguru.java2.hrsystem.core.requests.UpdateUserRoleRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.user.UpdateUserRoleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateUserRoleService {

    @Autowired ORMUserRepository ormUserRepository;
    @Autowired UpdateUserRoleValidator validator;

    public UpdateUserRoleResponse execute(UpdateUserRoleRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new UpdateUserRoleResponse(errors);
        }

        return new UpdateUserRoleResponse(ormUserRepository.updateUserRole(request.getId(),
               request.getUserRole()));
    }

}
