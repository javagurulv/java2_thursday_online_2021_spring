package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcBetDatabaseImpl implements BetDatabase{
    @Override
    public void addBet(Bet bet) {

    }

    @Override
    public boolean deleteBetById(Long id) {
        return false;
    }

    @Override
    public List<Bet> getAllBets() {
        return null;
    }
}
