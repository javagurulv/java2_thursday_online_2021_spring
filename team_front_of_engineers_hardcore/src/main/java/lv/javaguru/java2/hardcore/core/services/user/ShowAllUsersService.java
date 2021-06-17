package lv.javaguru.java2.hardcore.core.services.user;


import lv.javaguru.java2.hardcore.core.database.UserRepository;

import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.requests.user.ShowAllUserRequest;
import lv.javaguru.java2.hardcore.core.response.user.ShowAllUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class ShowAllUsersService {
    @Autowired
    private UserRepository userRepository;


    public ShowAllUsersResponse execute(ShowAllUserRequest request) {
        List<User> users = userRepository.getAllUsers();
        return new ShowAllUsersResponse(users);
    }
}
