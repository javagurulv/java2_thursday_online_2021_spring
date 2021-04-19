package lv.javaguru.java2.realestate.core.requests;

public class SearchOffersRequest {
    private final String offerType;
    private final String offerCategory;
    private final Double price;
    private final Integer id;

    public SearchOffersRequest(String offerType, String offerCategory, Double price, Integer id) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.price = price;
        this.id = id;
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

    public Integer getId() {
        return id;
    }

}
