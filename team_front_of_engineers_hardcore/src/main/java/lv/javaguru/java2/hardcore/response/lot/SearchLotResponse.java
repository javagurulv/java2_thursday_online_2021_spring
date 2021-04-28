package lv.javaguru.java2.hardcore.response.lot;

import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.CoreResponse;

import java.util.List;

public class SearchLotResponse extends CoreResponse {

    private List<Lot> lots;

    public SearchLotResponse(List<CoreError> errors) {
        super(errors);
    }



    public List<Lot> getLots() {
        return lots;
    }
}
