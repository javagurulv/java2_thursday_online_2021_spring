package lv.javaguru.java2.hardcore.database;




import lv.javaguru.java2.hardcore.datamodels.User;

import java.util.List;

public interface UserDatabase {

    void addUser(User user);

    void logIn(User user);

    List<User> getAllUsers();

}
