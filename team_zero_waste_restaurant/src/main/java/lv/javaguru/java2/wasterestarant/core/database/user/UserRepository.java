package lv.javaguru.java2.wasterestarant.core.database.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;

import java.util.List;

public interface UserRepository {

    void save(User user);

    boolean deleteUserById(Long id);

    List<User> getAllUsers();

    List<User> findUserById(Long userId);

    List<User> findUserByName(String name);

    List<User> findUserBySurname(String surname);

    List<User> findUserByEmail(String email);

    boolean changeUserPassword(String email);

    boolean changeUserRole(UserRole userRole, String email);

    boolean isUserRegistered(String email, String password);

    boolean isEmailRegistered(String email);

    boolean hasUserRightsToChangeRole(User user);

    List<User> findUserByRole(String role);


}
