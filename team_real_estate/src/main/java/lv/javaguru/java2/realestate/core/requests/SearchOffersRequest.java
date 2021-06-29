package lv.javaguru.java2.realestate.core.requests;

import lombok.Getter;

@Getter
public class SearchOffersRequest {
    private final String offerType;
    private final String offerCategory;
    private final Double price;

    private Ordering ordering;
    private Paging paging;

    public SearchOffersRequest(String offerType, String offerCategory, Double price) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.price = price;
    }

    public SearchOffersRequest(String offerType, String offerCategory, Double price, Ordering ordering) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.price = price;
        this.ordering = ordering;
    }

    public SearchOffersRequest(String offerType, String offerCategory, Double price, Paging paging) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.price = price;
        this.paging = paging;
    }

    public SearchOffersRequest(String offerType, String offerCategory, Double price, Ordering ordering, Paging paging) {
        this.offerType = offerType;
        this.offerCategory = offerCategory;
        this.price = price;
        this.ordering = ordering;
        this.paging = paging;
    }
}
