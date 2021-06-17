package lv.javaguru.java2.hardcore.core.services.bet;


import lv.javaguru.java2.hardcore.core.database.BetGetter;
import lv.javaguru.java2.hardcore.core.domain.Bet;
import lv.javaguru.java2.hardcore.core.requests.bet.GetHighestBetByLotIdRequest;
import lv.javaguru.java2.hardcore.core.response.bet.GetHighestBetByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Component
@Transactional
public class GetHighestBetByIdService {
    @Autowired
    private BetGetter betGetter;

    public Bet getHighestBetByLotId(Long id) {
        List<Bet> bets = betGetter.getBetListByLotId(id);
        Bet bet = new Bet();
        bet.setBet(BigDecimal.valueOf(0));
        for (Bet b: bets) {
            if(!b.getBet().equals(bet.getBet())){
                bet=b;
            }
        }
        return bet;
    }

   public GetHighestBetByIdResponse execute (GetHighestBetByLotIdRequest request){
       Bet bet = getHighestBetByLotId(request.getId());
       return new GetHighestBetByIdResponse(bet);
   }


}
