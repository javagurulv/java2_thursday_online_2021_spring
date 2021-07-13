package lv.javaguru.java2.hardcore.core.services.lot;

import lv.javaguru.java2.hardcore.core.database.LotRepository;

import lv.javaguru.java2.hardcore.core.requests.lot.RemoveLotRequest;
import lv.javaguru.java2.hardcore.core.response.lot.RemoveLotResponse;
import lv.javaguru.java2.hardcore.core.services.lot.validators.RemoveLotValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class RemoveLotService {
    @Autowired
    private LotRepository lotRepository;

    private RemoveLotValidator removeLotValidator;

    public RemoveLotResponse execute(RemoveLotRequest request) {

        boolean isRemoved = lotRepository.deleteLotById(request.getId());

        return new RemoveLotResponse(isRemoved);


    }
}
