package lv.javaguru.java2.hardcore.core.services.bet;

import lv.javaguru.java2.hardcore.core.database.BetDatabase;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import lv.javaguru.java2.hardcore.core.requests.bet.ShowAllBetsRequest;
import lv.javaguru.java2.hardcore.core.response.bet.ShowAllBetsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ShowAllBetsService {
    @Autowired
    private BetDatabase betDatabase;

    public ShowAllBetsResponse execute(ShowAllBetsRequest request) {
        List<Bet> bets = betDatabase.getAllBets();
        return new ShowAllBetsResponse(bets);
    }
}
