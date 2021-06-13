package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component
public class JdbcUserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(User user) {
        jdbcTemplate.update(
                "INSERT INTO users (name, password) "
                        + "VALUES (?, ?)",
                user.getName(), user.getPassword());

    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        String sql = "SELECT * FROM users "+
                "WHERE name = ?";
        Object[] args = new Object[] {login};
        User user = jdbcTemplate.queryForObject(sql,args,new UserRowMapper());
        return Optional.ofNullable(user);

    }


    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
}
