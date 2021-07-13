package lv.javaguru.java2.hardcore.core.services.lot;

import lv.javaguru.java2.hardcore.consoleUI.UserSession;
import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.database.LotRepository;
import lv.javaguru.java2.hardcore.core.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.core.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.services.lot.validators.AddLotValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class AddLotService {
    @Autowired
    private LotRepository lotRepository;
    @Autowired
    private AddLotValidator validator;
    @Autowired
    private UserSession userSession;





    public AddLotResponse execute(AddLotRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()&& userSession.isAuthorized()) {
            return new AddLotResponse(errors);
        }
        Lot lot = new Lot(request.getName(), request.getPrice(), userSession.getUserID());
        lotRepository.saveLot(lot);
        return new AddLotResponse(lot);

    }
}
