package lv.javaguru.java2.hardcore.response.bet;

import lv.javaguru.java2.hardcore.datamodels.Bet;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.CoreResponse;

import java.util.List;

public class AddBetResponse extends CoreResponse {

    private Bet newBet;

    public AddBetResponse(Bet newBet) {
        this.newBet = newBet;
    }

    public AddBetResponse(List<CoreError> errors) {
        super(errors);
    }

    public Bet getNewBet() {
        return newBet;
    }
}
