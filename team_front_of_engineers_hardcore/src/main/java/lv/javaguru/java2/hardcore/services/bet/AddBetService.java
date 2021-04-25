package lv.javaguru.java2.hardcore.services.bet;

import lv.javaguru.java2.hardcore.database.BetDatabase;
import lv.javaguru.java2.hardcore.domain.Bet;
import lv.javaguru.java2.hardcore.requests.bet.AddBetRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.bet.AddBetResponse;
import lv.javaguru.java2.hardcore.services.user.LoginService;

import java.util.List;
import java.util.Scanner;

public class AddBetService {

    private BetDatabase betDatabase;
    private AddBetValidator validator;
    private LoginService loginService;

    public AddBetService(BetDatabase betDatabase, AddBetValidator validator, LoginService loginService) {
        this.betDatabase = betDatabase;
        this.validator = validator;
        this.loginService = loginService;
    }

    public AddBetResponse execute(AddBetRequest request){
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new AddBetResponse(errors);
        }
        Bet bet = new Bet(request.getBet(),request.getId(),loginService.getCurrentUser(), loginService.getCurrentUserID());
        betDatabase.addBet(bet);
        return new AddBetResponse(bet);
    }

}
