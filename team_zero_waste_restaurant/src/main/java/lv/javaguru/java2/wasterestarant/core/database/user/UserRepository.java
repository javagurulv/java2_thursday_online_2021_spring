package lv.javaguru.java2.wasterestarant.core.database.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;

import java.util.List;

public interface UserRepository {

    void save(User user);

    boolean deleteUserById(Long id);

    List<User> getAllUsers();

    List<User> findUserById(Long userId);

    List<User> findUserByName(String name);

    List<User> findUserBySurname(String surname);

    List<User> findUserByEmail(String email);

    List<User> findUserByEmailAndPassword(String email, String password);

    boolean isUserRegistered(User user);

    List<User> findUserByRole(String role);


}
