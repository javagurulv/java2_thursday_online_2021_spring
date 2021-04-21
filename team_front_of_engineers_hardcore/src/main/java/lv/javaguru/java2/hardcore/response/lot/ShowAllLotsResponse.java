package lv.javaguru.java2.hardcore.response.lot;

import lv.javaguru.java2.hardcore.datamodels.Lot;
import lv.javaguru.java2.hardcore.response.CoreResponse;

import java.util.List;

public class ShowAllLotsResponse extends CoreResponse {

    private List<Lot> getAllLots;

    public ShowAllLotsResponse(List<Lot> getAllLots) {
        this.getAllLots = getAllLots;
    }

    public List<Lot> getGetAllLots() {

        return getAllLots;
    }
}
