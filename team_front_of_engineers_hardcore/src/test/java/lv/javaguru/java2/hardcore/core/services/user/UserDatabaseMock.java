package lv.javaguru.java2.hardcore.core.services.user;

import lv.javaguru.java2.hardcore.core.database.UserDatabase;
import lv.javaguru.java2.hardcore.core.domain.User;

import java.util.List;

public class UserDatabaseMock implements UserDatabase {
    @Override
    public void addUser(User user) {

    }

    @Override
    public void getUserByLogin(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

}
