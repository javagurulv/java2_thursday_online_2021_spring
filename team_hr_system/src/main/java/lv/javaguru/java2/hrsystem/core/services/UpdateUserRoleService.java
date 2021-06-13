package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.ORMUserRepository;
import lv.javaguru.java2.hrsystem.core.requests.UpdateUserRoleRequest;
import lv.javaguru.java2.hrsystem.core.responses.UpdateUserRoleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserRoleService {

    @Autowired ORMUserRepository ormUserRepository;

    public UpdateUserRoleResponse execute(UpdateUserRoleRequest updateUserRoleRequest) {

       return new UpdateUserRoleResponse (ormUserRepository.updateUserRole(updateUserRoleRequest.getId(),
               updateUserRoleRequest.getUserRole()));
    }

}
