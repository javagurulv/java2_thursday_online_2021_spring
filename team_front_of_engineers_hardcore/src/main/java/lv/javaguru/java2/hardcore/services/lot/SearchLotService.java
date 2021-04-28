package lv.javaguru.java2.hardcore.services.lot;

import com.sun.source.tree.LiteralTree;
import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.requests.lot.SearchLotRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.lot.SearchLotResponse;

import java.util.List;

public class SearchLotService {

private LotDatabase lotDatabase;
private SearchLotValidator validator;

    public SearchLotService(LotDatabase lotDatabase, SearchLotValidator validator) {
        this.lotDatabase = lotDatabase;
        this.validator = validator;
    }

    public void execute (SearchLotRequest request){
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
//            return new SearchLotResponse(errors);
        }
        List<Lot> lots = lotDatabase.getAllLots();
    }
}
