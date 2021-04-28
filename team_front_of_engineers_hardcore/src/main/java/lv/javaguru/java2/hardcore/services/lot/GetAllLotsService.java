package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.requests.lot.GetAllLotsRequest;
import lv.javaguru.java2.hardcore.response.lot.GetAllLotsResponse;

import java.util.List;


public class GetAllLotsService {
    private LotDatabase lotDatabase;

    public GetAllLotsService(LotDatabase lotDatabase) {
        this.lotDatabase = lotDatabase;
    }


    public GetAllLotsResponse execute(GetAllLotsRequest request) {
        List<Lot> lots = lotDatabase.getAllLots();


        return new GetAllLotsResponse(lots);
    }


}
