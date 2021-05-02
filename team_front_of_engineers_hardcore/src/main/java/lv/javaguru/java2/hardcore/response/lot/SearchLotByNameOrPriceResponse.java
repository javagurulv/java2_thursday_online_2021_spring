package lv.javaguru.java2.hardcore.response.lot;

import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.CoreResponse;

import java.util.List;

public class SearchLotByNameOrPriceResponse extends CoreResponse {

    private List<Lot> lots;

    public SearchLotByNameOrPriceResponse(List<Lot> lots) {
        this.lots = lots;
    }

    public SearchLotByNameOrPriceResponse(List<CoreError> errors, List<Lot> lots) {
        super(errors);
        this.lots = lots;
    }

    public List<Lot> getLots() {
        return lots;
    }
}
