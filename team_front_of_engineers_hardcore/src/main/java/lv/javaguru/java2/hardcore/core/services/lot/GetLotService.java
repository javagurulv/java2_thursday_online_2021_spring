package lv.javaguru.java2.hardcore.core.services.lot;


import lv.javaguru.java2.hardcore.core.database.LotRepository;
import lv.javaguru.java2.hardcore.core.requests.lot.GetLotRequest;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.lot.GetLotResponse;
import lv.javaguru.java2.hardcore.core.services.lot.validators.GetLotValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetLotService {

    @Autowired private LotRepository lotRepository;
    @Autowired private GetLotValidator validator;

    public GetLotResponse execute(GetLotRequest request){
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new GetLotResponse(errors);
        }
        return lotRepository.getById(request.getId())
                .map(GetLotResponse::new).orElseGet(()->{
            errors.add(new CoreError("id","Not found!"));
            return new GetLotResponse(errors);
        });
    }
}
