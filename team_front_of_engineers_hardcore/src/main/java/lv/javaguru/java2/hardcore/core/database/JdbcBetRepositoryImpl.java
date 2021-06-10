package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class JdbcBetRepositoryImpl implements BetRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBet(Bet bet) {
        jdbcTemplate.update(
                "INSERT INTO user_bets (lot_id,bet,user_id) "
                        + "VALUES (?, ? ,?)",
                bet.getLotId(),bet.getBet(),bet.getUserID());
    }

    @Override
    public boolean deleteBetById(Long id) {
        String sql = "DELETE FROM user_bets WHERE id = ?";
        Object[] args = new Object[] {id};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<Bet> getAllBets() {
        String sql = "SELECT * FROM user_bets";
        return jdbcTemplate.query(sql,new BetRowMapper());
    }
}
