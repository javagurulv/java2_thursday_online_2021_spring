package lv.javaguru.java2.hrsystem.core.database.mappers;

import lv.javaguru.java2.hrsystem.core.domain.User;
import lv.javaguru.java2.hrsystem.core.domain.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setUserRole(UserRole.valueOf(rs.getString("user_role")));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
