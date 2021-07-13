package lv.javaguru.java2.hrsystem.core.services.user;

import lv.javaguru.java2.hrsystem.core.database.ORMUserRepository;
import lv.javaguru.java2.hrsystem.core.requests.DeleteUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.*;
import lv.javaguru.java2.hrsystem.core.services.validators.user.DeleteUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeleteUserService {

    @Autowired ORMUserRepository ormUserRepository;
    @Autowired DeleteUserValidator validator;

    public DeleteUserResponse execute(DeleteUserRequest deleteUserRequest) {

        List<CoreError> errors = validator.validate(deleteUserRequest);

        if (!errors.isEmpty()) {
            return new DeleteUserResponse(errors);
        }

        boolean deleted = ormUserRepository.deleteUser(deleteUserRequest.getId());
        return new DeleteUserResponse(deleted);
    }
}
