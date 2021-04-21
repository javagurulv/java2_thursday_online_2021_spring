package lv.javaguru.java2.hardcore.services.bet;

import lv.javaguru.java2.hardcore.database.BetDatabase;
import lv.javaguru.java2.hardcore.datamodels.Bet;
import lv.javaguru.java2.hardcore.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.bet.AddBetResponse;

import java.util.List;

public class AddBetService {

    private BetDatabase betDatabase;
    private AddBetValidator validator;

    public AddBetService(BetDatabase betDatabase, AddBetValidator validator) {
        this.betDatabase = betDatabase;
        this.validator = validator;
    }

    public AddBetResponse execute(AddBetRequest request){
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new AddBetResponse(errors);
        }
        Bet bet = new Bet(request.getBet(),request.getId());
        betDatabase.addBet(bet);
        return new AddBetResponse(bet);
    }
}
