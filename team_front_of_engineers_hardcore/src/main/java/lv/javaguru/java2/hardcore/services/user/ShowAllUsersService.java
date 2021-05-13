package lv.javaguru.java2.hardcore.services.user;


import lv.javaguru.java2.hardcore.database.UserDatabase;

import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.user.ShowAllUserRequest;
import lv.javaguru.java2.hardcore.response.user.ShowAllUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ShowAllUsersService {
    @Autowired
    private UserDatabase userDatabase;


    public ShowAllUsersResponse execute(ShowAllUserRequest request) {
        List<User> users = userDatabase.getAllUsers();
        return new ShowAllUsersResponse(users);
    }
}
