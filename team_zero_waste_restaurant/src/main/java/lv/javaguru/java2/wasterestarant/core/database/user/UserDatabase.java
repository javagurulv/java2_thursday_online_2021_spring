package lv.javaguru.java2.wasterestarant.core.database.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;

import java.util.List;

public interface UserDatabase {

    void save(User user);

    boolean deleteUserById(Long userId);

    List<User> getAllUsers();

    List<User> searchUserById(Long userId);

    List<User> searchUserByName(String name);

    List<User> searchUserBySurname(String surname);

    List<User> searchUserByEmail(String email);

    List<UserRole> searchUserByRole(String role);


}
