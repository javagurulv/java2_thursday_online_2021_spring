package lv.javaguru.java2.hardcore.core.services.bet;

import lv.javaguru.java2.hardcore.core.database.BetDatabase;

import lv.javaguru.java2.hardcore.core.requests.bet.RemoveBetRequest;
import lv.javaguru.java2.hardcore.core.response.bet.RemoveBetResponse;
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
