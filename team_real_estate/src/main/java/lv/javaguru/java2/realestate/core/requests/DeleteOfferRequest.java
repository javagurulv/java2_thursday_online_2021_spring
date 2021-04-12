package lv.javaguru.java2.realestate.core.requests;

public class DeleteOfferRequest {
    private final String offerType;
    private final String propertyCategory;
    private final String description;
    private final double price;

    public DeleteOfferRequest(String offerType, String propertyCategory, String description, double price) {
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

    public double getPrice() {
        return price;
    }
}
