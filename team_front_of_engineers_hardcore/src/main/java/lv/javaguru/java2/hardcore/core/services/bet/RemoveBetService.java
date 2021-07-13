package lv.javaguru.java2.hardcore.core.services.bet;

import lv.javaguru.java2.hardcore.core.database.BetRepository;

import lv.javaguru.java2.hardcore.core.requests.bet.RemoveBetRequest;
import lv.javaguru.java2.hardcore.core.response.bet.RemoveBetResponse;
import lv.javaguru.java2.hardcore.core.services.bet.validators.RemoveBetValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class RemoveBetService {
    @Autowired
    private BetRepository betRepository;
    @Autowired
    private RemoveBetValidator validator;


    public RemoveBetResponse execute(RemoveBetRequest request) {
        boolean isRemoved = betRepository.deleteBetById(request.getBetIdToRemove());
        return new RemoveBetResponse(isRemoved);
    }
}
