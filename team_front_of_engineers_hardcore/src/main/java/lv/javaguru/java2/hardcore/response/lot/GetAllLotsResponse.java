package lv.javaguru.java2.hardcore.response.lot;


import lv.javaguru.java2.hardcore.domain.Lot;
import lv.javaguru.java2.hardcore.response.CoreResponse;

import java.util.List;

public class GetAllLotsResponse extends CoreResponse {

    private List<Lot> getAllLots;

    public GetAllLotsResponse(List<Lot> getAllLots) {
        this.getAllLots = getAllLots;
    }

    public List<Lot> getGetAllLots() {

        return getAllLots;
    }


}
