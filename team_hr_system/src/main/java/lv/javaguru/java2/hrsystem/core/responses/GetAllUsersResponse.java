package lv.javaguru.java2.hrsystem.core.responses;

import lv.javaguru.java2.hrsystem.core.domain.User;

import java.util.List;

public class GetAllUsersResponse {

    private List<User> users;

    public GetAllUsersResponse(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public boolean hasUsers() {
        return !users.isEmpty();
    }
}
