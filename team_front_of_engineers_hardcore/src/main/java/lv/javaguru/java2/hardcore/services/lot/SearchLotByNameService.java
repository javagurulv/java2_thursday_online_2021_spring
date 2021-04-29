package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.requests.lot.SearchLotByNameRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.lot.SearchLotByNameResponse;

import java.util.List;

public class SearchLotByNameService {

private LotDatabase lotDatabase;
private SearchLotByNameRequestValidator validator;

    public SearchLotByNameService(LotDatabase lotDatabase, SearchLotByNameRequestValidator validator) {
        this.lotDatabase = lotDatabase;
        this.validator = validator;
    }

    public SearchLotByNameResponse execute (SearchLotByNameRequest request){
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new SearchLotByNameResponse(errors,null);
        }
        List<Lot> lots = null;
        if(request.isNameProvided()){
            lots = lotDatabase.searchByName(request.getName());
        }
        return new SearchLotByNameResponse(null,lots);
    }
}
