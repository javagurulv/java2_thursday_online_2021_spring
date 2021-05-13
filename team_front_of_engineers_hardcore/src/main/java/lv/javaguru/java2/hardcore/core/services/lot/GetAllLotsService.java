package lv.javaguru.java2.hardcore.core.services.lot;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.database.LotDatabase;
import lv.javaguru.java2.hardcore.core.requests.lot.GetAllLotsRequest;
import lv.javaguru.java2.hardcore.core.response.lot.GetAllLotsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GetAllLotsService {
    @Autowired
    private LotDatabase lotDatabase;


    public GetAllLotsResponse execute(GetAllLotsRequest request) {
        List<Lot> lots = lotDatabase.getAllLots();


        return new GetAllLotsResponse(lots);
    }


}
