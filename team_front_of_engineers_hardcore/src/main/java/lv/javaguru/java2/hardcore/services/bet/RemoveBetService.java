package lv.javaguru.java2.hardcore.services.bet;

import lv.javaguru.java2.hardcore.database.BetDatabase;
import lv.javaguru.java2.hardcore.requests.bet.RemoveBetRequest;
import lv.javaguru.java2.hardcore.response.bet.RemoveBetResponse;

public class RemoveBetService {

    private BetDatabase betDatabase;
    private RemoveBetValidator validator;

    public RemoveBetService(BetDatabase betDatabase, RemoveBetValidator validator) {
        this.betDatabase = betDatabase;
        this.validator = validator;
    }

    public RemoveBetResponse execute(RemoveBetRequest request){
        boolean isRemoved = betDatabase.deleteBetById(request.getBetIdToRemove());
        return new RemoveBetResponse(isRemoved);
    }
}
