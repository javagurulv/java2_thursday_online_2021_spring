package lv.javaguru.java2.realestate.core.database.user;

import lv.javaguru.java2.realestate.core.domain.User;

public interface UserRepository {

    void createAccount(User user);

    boolean logIn(User user);

    boolean deleteUser(User user);

    User getUser(User user);
}
