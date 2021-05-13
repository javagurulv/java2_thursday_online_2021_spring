package lv.javaguru.java2.hardcore.core.response.bet;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

import java.util.List;

public class ShowAllBetsResponse extends CoreResponse {

    private List<Bet> showAllBets;

    public ShowAllBetsResponse(List<Bet> showAllBets) {
        this.showAllBets = showAllBets;
    }

    public List<Bet> getShowAllBets() {
        return showAllBets;
    }
}
