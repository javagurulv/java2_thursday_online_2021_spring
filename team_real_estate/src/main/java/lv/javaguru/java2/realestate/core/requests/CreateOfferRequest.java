package lv.javaguru.java2.realestate.core.requests;

import lombok.Getter;

@Getter
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


}
