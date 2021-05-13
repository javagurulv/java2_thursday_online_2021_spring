package lv.javaguru.java2.hardcore.core.response.user;

import lv.javaguru.java2.hardcore.core.domain.User;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

import java.util.List;

public class ShowAllUsersResponse extends CoreResponse {

    private List<User> getAllUsers;

    public ShowAllUsersResponse(List<User> getAllUsers) {
        this.getAllUsers = getAllUsers;
    }

    public List<User> getGetAllUsers() {
        return getAllUsers;
    }
}
