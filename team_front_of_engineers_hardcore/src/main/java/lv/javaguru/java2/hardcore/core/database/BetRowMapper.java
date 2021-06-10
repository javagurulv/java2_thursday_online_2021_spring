package lv.javaguru.java2.hardcore.core.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lv.javaguru.java2.hardcore.core.domain.Bet;

public class BetRowMapper implements RowMapper<Bet> {

    @Override
    public Bet mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bet bet = new Bet();
        bet.setId(rs.getLong("id"));
        bet.setLotId(rs.getLong("lot_id"));
        bet.setBet(rs.getBigDecimal("bet"));
        bet.setUserID(rs.getLong("user_id"));
        return bet;
    }
}
