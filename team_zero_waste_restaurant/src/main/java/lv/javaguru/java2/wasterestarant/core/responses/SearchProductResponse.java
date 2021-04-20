package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

public class SearchProductResponse extends CoreResponse{

    private List<Product> products;


    public SearchProductResponse(List<CoreError> errors, List<Product> products) {
        super(errors);
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
