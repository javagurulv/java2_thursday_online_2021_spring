package lv.javaguru.java2.hardcore.core.response.lot;


import lv.javaguru.java2.hardcore.core.domain.Lot;
import lv.javaguru.java2.hardcore.core.response.CoreResponse;

import java.util.List;

public class GetAllLotsResponse extends CoreResponse {

    private List<Lot> getAllLots;

    public GetAllLotsResponse(List<Lot> getAllLots) {
        this.getAllLots = getAllLots;
    }

    public GetAllLotsResponse() {
    }

    public List<Lot> getGetAllLots() {

        return getAllLots;
    }


}
