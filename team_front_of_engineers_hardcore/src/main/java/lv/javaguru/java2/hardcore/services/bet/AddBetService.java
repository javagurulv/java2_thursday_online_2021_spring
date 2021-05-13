package lv.javaguru.java2.hardcore.services.bet;

import lv.javaguru.java2.hardcore.database.BetDatabase;

import lv.javaguru.java2.hardcore.domain.Bet;
import lv.javaguru.java2.hardcore.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.bet.AddBetResponse;
import lv.javaguru.java2.hardcore.services.user.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AddBetService {
    @Autowired
    private BetDatabase betDatabase;
    @Autowired
    private AddBetValidator validator;
    @Autowired
    private LoginService loginService;


    public AddBetResponse execute(AddBetRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddBetResponse(errors);
        }
        Bet bet = new Bet(request.getBet(), request.getId(), null);
        betDatabase.addBet(bet);
        return new AddBetResponse(bet);
    }

}
