package lv.javaguru.java2.hardcore.core.database;


import lv.javaguru.java2.hardcore.core.domain.Bet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@Component
public class InMemoryBetRepositoryImpl implements BetRepository {

    private Long nextId = 1L;
    private List<Bet> bets = new ArrayList<>();


    @Override
    public void addBet(Bet bet) {
        bet.setLotId(nextId);
        nextId++;
        bets.add(bet);
    }

    @Override
    public List<Bet> getAllBets() {
        return bets;
    }

    @Override
    public boolean deleteBetById(Long id) {
        boolean isBetDeleted = false;
        Optional<Bet> betToDeleteOpt = bets.stream().filter(bet -> bet.getLotId().equals(id)).findFirst();
        if (betToDeleteOpt.isPresent()) {
            Bet betToRemove = betToDeleteOpt.get();
            isBetDeleted = bets.remove(betToRemove);
        }
        return isBetDeleted;
    }


}
