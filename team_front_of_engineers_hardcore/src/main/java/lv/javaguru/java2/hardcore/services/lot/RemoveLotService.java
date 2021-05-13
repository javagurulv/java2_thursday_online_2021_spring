package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.database.LotDatabase;

import lv.javaguru.java2.hardcore.requests.lot.RemoveLotRequest;
import lv.javaguru.java2.hardcore.response.lot.RemoveLotResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveLotService {
    @Autowired
    private LotDatabase lotDatabase;

    private RemoveLotValidator removeLotValidator;

    public RemoveLotResponse execute(RemoveLotRequest request) {

        boolean isRemoved = lotDatabase.deleteLotById(request.getLotIdToRemove());

        return new RemoveLotResponse(isRemoved);


    }
}
