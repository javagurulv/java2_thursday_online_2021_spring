package lv.javaguru.java2.realestate.core.requests;

public class SearchOffersRequest {
    private final String offerType;
    private final String offerCategory;
    private final Double price;

    private final Ordering ordering;
    private final Paging paging;

    public SearchOffersRequest(String offerType, String offerCategory, Double price, Ordering ordering,Paging paging) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.price = price;
        this.ordering = ordering;
        this.paging = paging;
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

    public Paging getPaging() {
        return paging;
    }
}
