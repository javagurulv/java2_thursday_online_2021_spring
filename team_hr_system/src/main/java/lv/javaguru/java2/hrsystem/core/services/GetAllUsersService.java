package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.jdbcrepos.UserRepository;
import lv.javaguru.java2.hrsystem.core.domain.User;
import lv.javaguru.java2.hrsystem.core.responses.GetAllUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUsersService {

    @Autowired
    private UserRepository userRepository;

    public GetAllUsersResponse execute() {
        List<User> userList = userRepository.getAllUsers();
        return new GetAllUsersResponse(userList);
    }
}
