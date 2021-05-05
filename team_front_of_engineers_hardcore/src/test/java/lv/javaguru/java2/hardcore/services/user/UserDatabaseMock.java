package lv.javaguru.java2.hardcore.services.user;

import lv.javaguru.java2.hardcore.database.UserDatabase;
import lv.javaguru.java2.hardcore.domain.User;

import java.util.List;

public class UserDatabaseMock implements UserDatabase {
    @Override
    public void addUser(User user) {

    }

    @Override
    public void logIn(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Long getUserId() {
        return null;
    }
}
