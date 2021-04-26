package lv.javaguru.java2.hardcore.database;




import lv.javaguru.java2.hardcore.domain.User;

import java.util.List;

public interface UserDatabase {

    void addUser(User user);

    void logIn(User user);

    List<User> getAllUsers();

    Long getUserId();

}
