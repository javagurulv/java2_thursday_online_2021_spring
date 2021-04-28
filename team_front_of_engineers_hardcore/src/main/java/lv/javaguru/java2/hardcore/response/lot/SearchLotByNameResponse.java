package lv.javaguru.java2.hardcore.response.lot;

import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.CoreResponse;

import java.util.List;

public class SearchLotByNameResponse extends CoreResponse {

    private List<Lot> lots;

    public SearchLotByNameResponse(List<Lot> lots) {
        this.lots = lots;
    }

    public SearchLotByNameResponse(List<CoreError> errors, List<Lot> lots) {
        super(errors);
        this.lots = lots;
    }

    public List<Lot> getLots() {
        return lots;
    }
}
