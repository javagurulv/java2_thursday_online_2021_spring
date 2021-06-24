package lv.javaguru.java2.wasterestarant.core.database.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//@Component
public class JdbcUserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO user_list(name, surname, email, password)"
                        + "VALUES (?, ?, ?, ?)",
                user.getFirstName(), user.getSecondName(), user.getEmail(), user.getPassword()
        );
    }

    @Override
    public boolean deleteUserById(Long id) {
        String sql = "DELETE FROM user_list WHERE userId = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user_list";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public List<User> findUserById(Long userId) {
        String sql = "SELECT * FROM user_list WHERE userId = ?";
        Object[] args = new Object[]{userId};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }

    @Override
    public List<User> findUserByName(String name) {
        String sql = "SELECT * FROM user_list WHERE name = ?";
        Object[] args = new Object[]{name};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }

    @Override
    public List<User> findUserBySurname(String surname) {
        String sql = "SELECT * FROM user_list WHERE surname = ?";
        Object[] args = new Object[]{surname};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }

    @Override
    public List<User> findUserByEmail(String email) {
        String sql = "SELECT * FROM user_list WHERE email = ?";
        Object[] args = new Object[]{email};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }

    @Override
    public List<User> findUserByNameAndPassword(String name, String password) {
        return null;
    }

    @Override
    public List<UserRole> findUserByRole(String role) {
        return null;
//        String sql = "SELECT * FROM user_list WHERE role = ?";
//        Object[] args = new Object[] {role};
//        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }
}
