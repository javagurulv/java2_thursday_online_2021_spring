package lv.javaguru.java2.realestate.core.response;

import lombok.Getter;
import lv.javaguru.java2.realestate.core.domain.Offer;

import java.util.List;

@Getter
public class CreateOfferResponse extends CoreResponse {

    private Offer offer;

    public CreateOfferResponse(List<CoreError> errors) {
        super(errors);
    }

    public CreateOfferResponse(Offer offer) {
        this.offer = offer;
    }
}
