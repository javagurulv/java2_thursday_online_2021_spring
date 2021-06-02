package lv.javaguru.java2.wasterestarant.core.database.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;

import java.util.List;

public class JdbcUserDatabase implements UserDatabase{
    @Override
    public void save(User user) {

    }

    @Override
    public boolean deleteUserById(Long userId) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public List<User> searchUserById(Long userId) {
        return null;
    }

    @Override
    public List<User> searchUserByName(String name) {
        return null;
    }

    @Override
    public List<User> searchUserBySurname(String surname) {
        return null;
    }

    @Override
    public List<User> searchUserByEmail(String email) {
        return null;
    }

    @Override
    public List<UserRole> searchUserByRole(String role) {
        return null;
    }
}
