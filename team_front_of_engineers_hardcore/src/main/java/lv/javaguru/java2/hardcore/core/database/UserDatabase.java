package lv.javaguru.java2.hardcore.core.database;


import lv.javaguru.java2.hardcore.core.domain.User;

import java.util.List;

public interface UserDatabase {

    void addUser(User user);

    void logIn(User user);

    List<User> getAllUsers();

}
