package lv.javaguru.java2.hardcore.response.lot;

import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.response.CoreError;
import lv.javaguru.java2.hardcore.response.CoreResponse;

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
