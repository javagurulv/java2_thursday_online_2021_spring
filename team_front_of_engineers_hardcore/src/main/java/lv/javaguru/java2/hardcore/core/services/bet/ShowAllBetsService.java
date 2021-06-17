package lv.javaguru.java2.hardcore.core.services.bet;

import lv.javaguru.java2.hardcore.core.database.BetRepository;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import lv.javaguru.java2.hardcore.core.requests.bet.ShowAllBetsRequest;
import lv.javaguru.java2.hardcore.core.response.bet.ShowAllBetsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class ShowAllBetsService {
    @Autowired
    private BetRepository betRepository;

    public ShowAllBetsResponse execute(ShowAllBetsRequest request) {
        List<Bet> bets = betRepository.getAllBets();
        return new ShowAllBetsResponse(bets);
    }
}
