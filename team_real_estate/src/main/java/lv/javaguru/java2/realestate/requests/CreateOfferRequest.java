package lv.javaguru.java2.realestate.requests;

public class CreateOfferRequest {

    String offerType;
    String propertyCategory;
    String description;
    double price;

    public CreateOfferRequest(String offerType, String propertyCategory, String description, double price) {
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
