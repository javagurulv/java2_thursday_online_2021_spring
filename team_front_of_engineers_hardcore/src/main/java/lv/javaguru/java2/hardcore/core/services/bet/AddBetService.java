package lv.javaguru.java2.hardcore.core.services.bet;

import lv.javaguru.java2.hardcore.consoleUI.UserSession;
import lv.javaguru.java2.hardcore.core.database.BetRepository;

import lv.javaguru.java2.hardcore.core.domain.Bet;
import lv.javaguru.java2.hardcore.core.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.bet.AddBetResponse;
import lv.javaguru.java2.hardcore.core.services.bet.validators.AddBetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class AddBetService {
    @Autowired
    private BetRepository betRepository;
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
        betRepository.addBet(bet);
        return new AddBetResponse(bet);
    }

}
