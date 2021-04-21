package lv.javaguru.java2.realestate.core.requests;

public class SearchOffersRequest {
    private final String offerType;
    private final String offerCategory;
    private final Double price;

    private final Ordering ordering;

    public SearchOffersRequest(String offerType, String offerCategory, Double price, Ordering ordering) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.price = price;
        this.ordering = ordering;
    }

    public String getOfferType() {
        return offerType;
    }

    public String getOfferCategory() {
        return offerCategory;
    }

    public Double getPrice() {
        return price;
    }

    public Ordering getOrdering() {
        return ordering;
    }
}
