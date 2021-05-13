package lv.javaguru.java2.hardcore.core.database;


import lv.javaguru.java2.hardcore.core.domain.Bet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class InMemoryBetDatabase implements BetDatabase {

    private Long nextId = 1L;
    private List<Bet> bets = new ArrayList<>();


    @Override
    public void addBet(Bet bet) {
        bet.setBetId(nextId);
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
        Optional<Bet> betToDeleteOpt = bets.stream().filter(bet -> bet.getBetId().equals(id)).findFirst();
        if (betToDeleteOpt.isPresent()) {
            Bet betToRemove = betToDeleteOpt.get();
            isBetDeleted = bets.remove(betToRemove);
        }
        return isBetDeleted;
    }


}
