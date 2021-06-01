package lv.javaguru.java2.hrsystem.core.database;

import lv.javaguru.java2.hrsystem.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "SELECT email, password FROM users WHERE email = ? AND password = ?";
        Object[] args = new Object[]{email, password};
        return jdbcTemplate.query(sql, args, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        }).stream().findFirst();
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

}
