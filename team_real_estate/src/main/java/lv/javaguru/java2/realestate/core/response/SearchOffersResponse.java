package lv.javaguru.java2.realestate.core.response;

import lombok.Getter;
import lv.javaguru.java2.realestate.core.domain.Offer;

import java.util.List;

@Getter
public class SearchOffersResponse extends CoreResponse {
    private final List<Offer> foundOffers;

    public SearchOffersResponse(List<CoreError> errors, List<Offer> foundOffers) {
        super(errors);
        this.foundOffers = foundOffers;
    }
}
