package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AddLotService {
    @Autowired
    private LotDatabase lotDatabase;
    @Autowired
    private AddLotValidator validator;





    public AddLotResponse execute(AddLotRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddLotResponse(errors);
        }
        Lot lot = new Lot(request.getName(), request.getPrice(), null);
        lotDatabase.saveLot(lot);
        return new AddLotResponse(lot);

    }
}
