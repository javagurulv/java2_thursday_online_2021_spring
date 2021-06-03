package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcUserDatabaseImpl implements UserDatabase {

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
    public void logIn(User user) {
        String sql = "SELECT name, password FROM users WHERE " + "name = '" + user.getName() + "' AND " + "password = '" + user.getPassword() + "'";
        User user1 = (User) jdbcTemplate.queryForObject(sql,new Object[]{user},User.class);
//        String sql = "SELECT name FROM users WHERE name=?";
//        String username = (String) jdbcTemplate.queryForObject(
//                sql, new Object[] { user.getName()}, String.class);
//        String sqlTwo = "SELECT password FROM users WHERE password=?";
//        String password = (String) jdbcTemplate.queryForObject(
//                sqlTwo, new Object[] { user.getPassword() }, String.class);

//        if(user.getName().equals(username)&&user.getPassword().equals(password)){
        if(user.equals(user1)){
            System.out.println("Welcome: " + user.getName());
        }else{
            System.out.println("Username or password are incorrect,please try again");
        }

    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
}
