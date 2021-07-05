package lv.javaguru.java2.wasterestarant.core.database.user;

import lv.javaguru.java2.wasterestarant.core.domain.User;
import lv.javaguru.java2.wasterestarant.core.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

//@Component
public class JdbcUserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users(firstName, secondName, email, password)"
                        + "VALUES (?, ?, ?, ?)",
                user.getName(), user.getSurname(), user.getEmail(), user.getPassword()
        );
    }

    @Override
    public boolean deleteUserById(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        Object[] args = new Object[]{id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public List<User> findUserById(Long userId) {
        String sql = "SELECT * FROM users WHERE userId = ?";
        Object[] args = new Object[]{userId};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }

    @Override
    public List<User> findUserByName(String firstName) {
        String sql = "SELECT * FROM users WHERE firstName = ?";
        Object[] args = new Object[]{firstName};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }

    @Override
    public List<User> findUserBySurname(String secondName) {
        String sql = "SELECT * FROM users WHERE secondName = ?";
        Object[] args = new Object[]{secondName};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }

    @Override
    public List<User> findUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        Object[] args = new Object[]{email};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }

    @Override
    public boolean changeUserPassword(String password, String email) {
        return false;
    }

    @Override
    public boolean changeUserRole(UserRole userRole, String email) {
        return false;
    }

    @Override
    public boolean isUserRegistered(String email, String password) {
        return false;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return null;
    }


    @Override
    public boolean isEmailRegistered(String email) {
        return false;
    }

    @Override
    public List<User> findUserByRole(String userRole) {
        String sql = "SELECT * FROM users WHERE user_role = ?";
        Object[] args = new Object[] {userRole};
        return jdbcTemplate.query(sql, args, new UserRowMapper());
    }
}
