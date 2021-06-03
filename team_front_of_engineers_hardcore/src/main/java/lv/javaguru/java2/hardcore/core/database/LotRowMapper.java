package lv.javaguru.java2.hardcore.core.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lv.javaguru.java2.hardcore.core.domain.Lot;

public class LotRowMapper implements RowMapper<Lot> {

    @Override
    public Lot mapRow(ResultSet rs, int rowNum) throws SQLException {
        Lot lot = new Lot();
        lot.setId(rs.getLong("id"));
        lot.setName(rs.getString("name"));
        lot.setStartPrice(rs.getBigDecimal("start_price"));
        lot.setUserID(rs.getLong("user_id"));
        return lot;
    }
}
