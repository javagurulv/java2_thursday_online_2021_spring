package lv.javaguru.java2.realestate.domain;

import java.util.Objects;

public class Offer {
    String offerType;
    String propertyCategory;
    String description;
    double price;

    public Offer(String offerType, String propertyCategory, String description, double price) {
        this.offerType = offerType;
        this.propertyCategory = propertyCategory;
        this.description = description;
        this.price = price;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getPropertyCategory() {
        return propertyCategory;
    }

    public void setPropertyCategory(String propertyCategory) {
        this.propertyCategory = propertyCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.price, price) == 0
                && Objects.equals(offerType, offer.offerType)
                && Objects.equals(propertyCategory, offer.propertyCategory)
                && Objects.equals(description, offer.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerType, propertyCategory, description, price);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerType='" + offerType + '\'' +
                ", propertyCategory='" + propertyCategory + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +" $"+ '}';
    }
}
