package lv.javaguru.java2.hardcore.services.bet;

import lv.javaguru.java2.hardcore.database.BetDatabase;

import lv.javaguru.java2.hardcore.requests.bet.RemoveBetRequest;
import lv.javaguru.java2.hardcore.response.bet.RemoveBetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveBetService {
    @Autowired
    private BetDatabase betDatabase;
    private RemoveBetValidator validator;


    public RemoveBetResponse execute(RemoveBetRequest request) {
        boolean isRemoved = betDatabase.deleteBetById(request.getBetIdToRemove());
        return new RemoveBetResponse(isRemoved);
    }
}
