package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.requests.lot.GetAllLotsRequest;
import lv.javaguru.java2.hardcore.response.lot.GetAllLotsResponse;
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
