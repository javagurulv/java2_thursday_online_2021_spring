package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.requests.lot.RemoveLotRequest;
import lv.javaguru.java2.hardcore.response.lot.RemoveLotResponse;

public class RemoveLotService {

    private LotDatabase lotDatabase;
    private RemoveLotValidator removeLotValidator;

    public RemoveLotService(LotDatabase lotDatabase, RemoveLotValidator removeLotValidator) {
        this.lotDatabase = lotDatabase;
        this.removeLotValidator = removeLotValidator;
    }

    public RemoveLotResponse execute(RemoveLotRequest request){

        boolean isRemoved = lotDatabase.deleteLotById(request.getLotIdToRemove());

        return new RemoveLotResponse(isRemoved);


    }
}
