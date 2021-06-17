package lv.javaguru.java2.hardcore.core.response.bet;

import lv.javaguru.java2.hardcore.core.domain.Bet;

public class GetHighestBetByIdResponse {

    private Bet bet;

    public GetHighestBetByIdResponse(Bet bet) {
        this.bet = bet;
    }

    public Bet getBet() {
        return bet;
    }
}
