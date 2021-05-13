package lv.javaguru.java2.hardcore.core.response.lot;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

import java.util.List;

public class SearchLotByNameOrPriceResponse extends CoreResponse {

    private List<Lot> lots;

    public SearchLotByNameOrPriceResponse(List<CoreError> errors, List<Lot> lots) {
        super(errors);
        this.lots = lots;
    }

    public List<Lot> getLots() {
        return lots;
    }
}
