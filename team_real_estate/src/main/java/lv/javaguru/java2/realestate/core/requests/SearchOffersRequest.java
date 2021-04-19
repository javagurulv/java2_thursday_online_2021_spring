package lv.javaguru.java2.realestate.core.requests;

public class SearchOffersRequest {
    private final String offerType;
    private final String offerCategory;
    private final Double price;

    public SearchOffersRequest(String offerType, String offerCategory, Double price) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.price = price;

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



}
