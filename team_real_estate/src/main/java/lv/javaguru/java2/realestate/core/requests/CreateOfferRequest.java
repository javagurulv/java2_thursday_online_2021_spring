package lv.javaguru.java2.realestate.core.requests;

public class CreateOfferRequest {

    private final String offerType;
    private final String offerCategory;
    private final String description;
    private final Double price;

    public CreateOfferRequest(String offerType, String offerCategory, String description, Double price) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.description = description;
        this.price = price;
    }

    public String getOfferType() {
        return offerType;
    }

    public String getOfferCategory() {
        return offerCategory;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
