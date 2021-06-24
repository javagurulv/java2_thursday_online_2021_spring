package lv.javaguru.java2.wasterestarant.core.database.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    boolean deleteUserById(Long id);

    List<User> getAllUsers();

    List<User> findUserById(Long userId);

    List<User> findUserByName(String name);

    List<User> findUserBySurname(String surname);

    List<User> findUserByEmail(String email);

    Optional<User> findUserByEmailAndPassword(String email, String password);

    List<User> findUserByRole(String role);


}
