package lv.javaguru.java2.hardcore.core.response.lot;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

import java.util.List;

public class GetLotResponse extends CoreResponse {

    private Lot lot;

    public GetLotResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetLotResponse(Lot lot) {
        this.lot = lot;
    }

    public Lot getLot() {
        return lot;
    }
}
