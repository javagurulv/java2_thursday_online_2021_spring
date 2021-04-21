package lv.javaguru.java2.hardcore.database;

import lv.javaguru.java2.hardcore.datamodels.Bet;

import java.util.List;

public interface BetDatabase {

    void addBet(Bet bet);

    boolean deleteBetById(Long id);

    List<Bet> getAllBets();
}
