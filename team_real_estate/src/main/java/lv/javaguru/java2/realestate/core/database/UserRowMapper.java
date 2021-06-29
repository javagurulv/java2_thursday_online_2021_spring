package lv.javaguru.java2.realestate.core.database;

import lv.javaguru.java2.realestate.core.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(
                rs.getString("username"),
                rs.getString("password")
        );
        user.setId(rs.getInt("id"));
        return user;
    }
}
