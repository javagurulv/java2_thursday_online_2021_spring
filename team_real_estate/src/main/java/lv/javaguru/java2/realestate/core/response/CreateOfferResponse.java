package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.Offer;

public class CreateOfferResponse {

    private final Offer offer;

    public CreateOfferResponse(Offer offer) {
        this.offer = offer;
    }

    public Offer getOffer() {
        return offer;
    }
}
