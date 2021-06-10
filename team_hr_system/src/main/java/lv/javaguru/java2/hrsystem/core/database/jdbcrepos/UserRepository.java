package lv.javaguru.java2.hrsystem.core.database.jdbcrepos;

import lv.javaguru.java2.hrsystem.core.database.mappers.UserRowMapper;
import lv.javaguru.java2.hrsystem.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {

    @Autowired private JdbcTemplate jdbcTemplate;

    public void registerUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO users (user_role, first_name, last_name, email, password) "
                        + "VALUES (?, ?, ?, ?, ?)",
                user.getUserRole().toString(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword()
        );
    }

    public Optional<User> authorizeUser(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        Object[] args = new Object[]{email, password};
        return jdbcTemplate.query(sql, args, new UserRowMapper()).stream().findFirst();
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

}
