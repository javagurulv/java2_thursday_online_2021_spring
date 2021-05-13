package lv.javaguru.java2.hardcore.core.response.lot;

import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.response.CoreError;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

import java.util.List;

public class AddLotResponse extends CoreResponse {

    private Lot newLot;

    public AddLotResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddLotResponse(Lot newLot) {
        this.newLot = newLot;
    }

    public Lot getNewLot() {
        return newLot;
    }
}
