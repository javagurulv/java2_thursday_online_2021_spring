package lv.javaguru.java2.hrsystem.core.services.user;

import lv.javaguru.java2.hrsystem.core.database.ORMUserRepository;
import lv.javaguru.java2.hrsystem.core.requests.DeleteUserRequest;
import lv.javaguru.java2.hrsystem.core.responses.DeleteUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserService {

    @Autowired ORMUserRepository ormUserRepository;

    public DeleteUserResponse execute(DeleteUserRequest deleteUserRequest) {

        boolean deleted = ormUserRepository.deleteUser(deleteUserRequest.getId());
        return new DeleteUserResponse(deleted);
    }
}
