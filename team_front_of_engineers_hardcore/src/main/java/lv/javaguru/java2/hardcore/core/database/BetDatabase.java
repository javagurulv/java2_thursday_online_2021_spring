package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Bet;

import java.util.List;

public interface BetDatabase {

    void addBet(Bet bet);

    boolean deleteBetById(Long id);

    List<Bet> getAllBets();
}
