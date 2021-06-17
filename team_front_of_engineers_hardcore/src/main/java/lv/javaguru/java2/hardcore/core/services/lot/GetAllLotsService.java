package lv.javaguru.java2.hardcore.core.services.lot;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.database.LotRepository;
import lv.javaguru.java2.hardcore.core.requests.lot.GetAllLotsRequest;
import lv.javaguru.java2.hardcore.core.response.lot.GetAllLotsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class GetAllLotsService {
    @Autowired
    private LotRepository lotRepository;


    public GetAllLotsResponse execute(GetAllLotsRequest request) {
        List<Lot> lots = lotRepository.getAllLots();


        return new GetAllLotsResponse(lots);
    }


}
