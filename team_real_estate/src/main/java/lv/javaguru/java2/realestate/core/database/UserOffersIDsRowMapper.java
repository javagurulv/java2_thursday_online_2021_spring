package lv.javaguru.java2.realestate.core.database;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOffersIDsRowMapper implements RowMapper<Integer> {
    @Override
    public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Integer.valueOf(rs.getInt("offer_id"));
    }
}
