package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.datamodels.Lot;
import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.requests.lot.AddLotRequest;
import lv.javaguru.java2.hardcore.response.lot.AddLotResponse;
import lv.javaguru.java2.hardcore.response.CoreError;

import java.util.List;

public class AddLotService{

    private LotDatabase lotDatabase;
    private AddLotValidator validator;

    public AddLotService(LotDatabase lotDatabase, AddLotValidator validator) {
        this.lotDatabase = lotDatabase;
        this.validator = validator;
    }

    public AddLotResponse execute(AddLotRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new AddLotResponse(errors);
        }
        Lot lot = new Lot(request.getName(), request.getPrice());
        lotDatabase.saveLot(lot);
        return new AddLotResponse(lot);

    }
}
