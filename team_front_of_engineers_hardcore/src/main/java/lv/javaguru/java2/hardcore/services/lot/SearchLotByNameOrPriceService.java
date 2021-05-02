package lv.javaguru.java2.hardcore.services.lot;

import lv.javaguru.java2.hardcore.database.LotDatabase;
import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.requests.lot.SearchLotByNameOrPriceRequest;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.lot.SearchLotByNameOrPriceResponse;

import java.util.List;

public class SearchLotByNameOrPriceService {

    private LotDatabase lotDatabase;
    private SearchLotByNameOrPriceRequestValidator validator;

    public SearchLotByNameOrPriceService(LotDatabase lotDatabase, SearchLotByNameOrPriceRequestValidator validator) {
        this.lotDatabase = lotDatabase;
        this.validator = validator;
    }

    public SearchLotByNameOrPriceResponse execute(SearchLotByNameOrPriceRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchLotByNameOrPriceResponse(errors, null);
        }
        List<Lot> lots = null;
        if (request.isNameProvided() && !request.isPriceProvided()) {
            lots = lotDatabase.searchByName(request.getName());
        }
        if (!request.isNameProvided() && request.isPriceProvided()) {
            lots = lotDatabase.searchByPrice(request.getPrice());
        }
        if(request.isNameProvided() && request.isPriceProvided()){
            lots = lotDatabase.searchByNameAndPrice(request.getName(),request.getPrice());
        }
        return new SearchLotByNameOrPriceResponse(null, lots);
    }
}
