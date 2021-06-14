package lv.javaguru.java2.hrsystem.core.services.user;

import lv.javaguru.java2.hrsystem.core.database.ORMUserRepository;
import lv.javaguru.java2.hrsystem.core.domain.User;
import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUsersService {

    @Autowired
    private ORMUserRepository ormUserRepository;

    public GetAllUsersResponse execute() {
        List<User> userList = ormUserRepository.getAllUsers();
        return new GetAllUsersResponse(userList);
    }
}
