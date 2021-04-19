package lv.javaguru.java2.realestate.core.response;

import lv.javaguru.java2.realestate.core.domain.Offer;
import java.util.List;

public class SearchOffersResponse extends CoreResponse{
    private final List<Offer> foundOffers;

    public SearchOffersResponse(List<CoreError> errors, List<Offer> foundOffers) {
        super(errors);
        this.foundOffers = foundOffers;
    }

    public List<Offer> getFoundOffers() {
        return foundOffers;
    }
}
