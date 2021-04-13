package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.Offer;

import java.util.List;

public class CreateOfferResponse extends CoreResponse {

    private Offer offer;

    public CreateOfferResponse(List<CoreError> errors) {
        super(errors);
    }

    public CreateOfferResponse(Offer offer) {
        this.offer = offer;
    }

    public Offer getOffer() {
        return offer;
    }
}
