package lv.javaguru.java2.hardcore.core.services.bet;



import lv.javaguru.java2.hardcore.core.database.BetGetter;
import lv.javaguru.java2.hardcore.core.domain.Bet;
import lv.javaguru.java2.hardcore.core.requests.bet.GetAllBetsForLotByLotIdRequest;
import lv.javaguru.java2.hardcore.core.response.bet.GetAllBetsForLotByLotIdResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAllBetsByLotIdService {

    @Autowired
    private BetGetter betGetter;

    public GetAllBetsForLotByLotIdResponse execute(GetAllBetsForLotByLotIdRequest request){
        List<Bet> bets = betGetter.getBetListByLotId(request.getId());
        return new GetAllBetsForLotByLotIdResponse(bets);
    }

}
