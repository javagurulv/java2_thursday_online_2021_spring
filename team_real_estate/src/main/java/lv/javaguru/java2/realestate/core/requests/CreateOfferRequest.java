package lv.javaguru.java2.realestate.core.requests;

public class CreateOfferRequest {

    private final String offerType;
    private final String propertyCategory;
    private final String description;
    private final Double price;

    public CreateOfferRequest(String offerType, String propertyCategory, String description, Double price) {
        this.offerType = offerType;
        this.propertyCategory = propertyCategory;
        this.description = description;
        this.price = price;
    }

    public String getOfferType() {
        return offerType;
    }

    public String getPropertyCategory() {
        return propertyCategory;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
