package lv.javaguru.java2.hardcore.response.user;

import lv.javaguru.java2.hardcore.domain.User;
import lv.javaguru.java2.hardcore.response.CoreResponse;

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
