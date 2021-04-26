package lv.javaguru.java2.hardcore.response.bet;

import lv.javaguru.java2.hardcore.domain.Bet;
import lv.javaguru.java2.hardcore.response.CoreResponse;

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
