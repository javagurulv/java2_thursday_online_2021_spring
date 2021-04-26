package lv.javaguru.java2.hardcore.services.user;



import lv.javaguru.java2.hardcore.database.UserDatabase;
import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.requests.user.ShowAllUserRequest;
import lv.javaguru.java2.hardcore.response.user.ShowAllUsersResponse;

import java.util.List;

public class ShowAllUsersService {

    private UserDatabase userDatabase;

    public ShowAllUsersService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public ShowAllUsersResponse execute(ShowAllUserRequest request){
        List<User> users = userDatabase.getAllUsers();
        return new ShowAllUsersResponse(users);
    }
}
