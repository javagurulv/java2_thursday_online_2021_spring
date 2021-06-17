package lv.javaguru.java2.hardcore.core.database;

import lv.javaguru.java2.hardcore.core.domain.Bet;

import java.util.List;

public interface BetGetter {



    public List<Bet> getBetListByLotId (Long id);

}
