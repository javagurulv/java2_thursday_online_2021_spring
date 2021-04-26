package lv.javaguru.java2.hardcore.services.bet;

import lv.javaguru.java2.hardcore.database.BetDatabase;
import lv.javaguru.java2.hardcore.domain.Bet;
import lv.javaguru.java2.hardcore.requests.bet.ShowAllBetsRequest;
import lv.javaguru.java2.hardcore.response.bet.ShowAllBetsResponse;

import java.util.List;

public class ShowAllBetsService {

    private BetDatabase betDatabase;

    public ShowAllBetsService(BetDatabase betDatabase) {
        this.betDatabase = betDatabase;
    }

    public ShowAllBetsResponse execute(ShowAllBetsRequest request){
        List<Bet> bets = betDatabase.getAllBets();
        return new ShowAllBetsResponse(bets);
    }
}
