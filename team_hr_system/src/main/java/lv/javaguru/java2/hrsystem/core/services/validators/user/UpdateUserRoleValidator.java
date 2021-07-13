package lv.javaguru.java2.hrsystem.core.services.validators.user;

import lv.javaguru.java2.hrsystem.core.database.ORMUserRepository;
import lv.javaguru.java2.hrsystem.core.requests.UpdateUserRoleRequest;
import lv.javaguru.java2.hrsystem.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UpdateUserRoleValidator {

    @Autowired ORMUserRepository ormUserRepository;

    public List<CoreError> validate(UpdateUserRoleRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateId(request).ifPresent(errors::add);
        ifIdNotExist(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateId(UpdateUserRoleRequest request) {
        return (request.getId() == null)
                ? Optional.of(new CoreError("id", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> ifIdNotExist(UpdateUserRoleRequest request) {
        if (ormUserRepository.getAllUsers().stream()
                .filter(user -> user.getId().equals(request.getId()))
                .findFirst()
                .isEmpty()) {
            return Optional.of(new CoreError("id", "not exist!"));
        } else {
            return Optional.empty();
        }
    }

}
