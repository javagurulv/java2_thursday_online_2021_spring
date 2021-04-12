package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.Offer;

import java.util.List;

public class GetAllOffersResponse {
    private final List<Offer> offerList;

    public GetAllOffersResponse(List<Offer> offerList) {
        this.offerList = offerList;
    }

    public List<Offer> getOfferList() {
        return offerList;
    }
}
