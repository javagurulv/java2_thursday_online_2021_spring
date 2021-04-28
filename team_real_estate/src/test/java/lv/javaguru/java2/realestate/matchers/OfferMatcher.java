package lv.javaguru.java2.realestate.matchers;

import lv.javaguru.java2.realestate.core.domain.Offer;
import org.mockito.ArgumentMatcher;

public class OfferMatcher implements ArgumentMatcher<Offer> {
    private final String offerType;
    private final String offerCategory;
    private final String description;
    private final Double price;

    public OfferMatcher(String offerType, String offerCategory, String description, Double price) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean matches(Offer offer) {
        return offer.getOfferType().equals(offerType)
                && offer.getOfferCategory().equals(offerCategory)
                && offer.getDescription().equals(description)
                && offer.getPrice().equals(price);
    }
}
