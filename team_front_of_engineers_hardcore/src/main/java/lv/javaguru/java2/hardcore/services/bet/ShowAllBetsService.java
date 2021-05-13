package lv.javaguru.java2.hardcore.services.bet;

import lv.javaguru.java2.hardcore.database.BetDatabase;

import lv.javaguru.java2.hardcore.domain.Bet;
import lv.javaguru.java2.hardcore.requests.bet.ShowAllBetsRequest;
import lv.javaguru.java2.hardcore.response.bet.ShowAllBetsResponse;
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
