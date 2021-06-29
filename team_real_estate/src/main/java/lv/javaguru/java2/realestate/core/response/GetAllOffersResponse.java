package lv.javaguru.java2.realestate.core.response;

import lombok.Getter;
import lv.javaguru.java2.realestate.core.domain.Offer;

import java.util.List;

@Getter
public class GetAllOffersResponse extends CoreResponse {
    private final List<Offer> offerList;

    public GetAllOffersResponse(List<Offer> offerList) {
        this.offerList = offerList;
    }

}
