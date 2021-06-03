package lv.javaguru.java2.hardcore.core.services.bet;

import lv.javaguru.java2.hardcore.consoleUI.UserSession;
import lv.javaguru.java2.hardcore.core.database.BetDatabase;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import lv.javaguru.java2.hardcore.core.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.bet.AddBetResponse;
import lv.javaguru.java2.hardcore.core.services.user.LoginService;
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
    private UserSession userSession;


    public AddBetResponse execute(AddBetRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddBetResponse(errors);
        }
        Bet bet = new Bet(request.getBet(), request.getId(), userSession.getUserID());
        betDatabase.addBet(bet);
        return new AddBetResponse(bet);
    }

}
