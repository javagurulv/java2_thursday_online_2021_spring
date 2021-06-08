package lv.javaguru.java2.realestate.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", nullable = false)
    private String offerType;

    @Column(name = "category", nullable = false)
    private String offerCategory;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    public Offer() {
    }

    public Offer(String offerType, String offerCategory, String description, Double price) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.description = description;
        this.price = price;
    }


    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getOfferCategory() {
        return offerCategory;
    }

    public void setOfferCategory(String offerCategory) {
        this.offerCategory = offerCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.price, price) == 0
                && Objects.equals(offerType, offer.offerType)
                && Objects.equals(offerCategory, offer.offerCategory)
                && Objects.equals(description, offer.description)
                && Objects.equals(id, offer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerType, offerCategory, description, price);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerType='" + offerType + '\'' +
                ", propertyCategory='" + offerCategory + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price + "$" + '\'' +
                ", id='" + id + '}';
    }
}
