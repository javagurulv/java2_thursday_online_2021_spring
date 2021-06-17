package lv.javaguru.java2.hardcore.core.response.bet;

import lv.javaguru.java2.hardcore.core.domain.Bet;

import java.util.List;

public class GetAllBetsForLotByLotIdResponse {

    private List<Bet> showAllBetsByLotId;

    public GetAllBetsForLotByLotIdResponse(List<Bet> getAllBetsByLotId) {
        this.showAllBetsByLotId = getAllBetsByLotId;
    }

    public List<Bet> getGetAllBetsByLotId() {
        return showAllBetsByLotId;
    }
}
