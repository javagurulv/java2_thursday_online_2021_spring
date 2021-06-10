package lv.javaguru.java2.hardcore.core.database;


import lv.javaguru.java2.hardcore.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void addUser(User user);

    Optional<User> getUserByLogin(String name);

    List<User> getAllUsers();

}
