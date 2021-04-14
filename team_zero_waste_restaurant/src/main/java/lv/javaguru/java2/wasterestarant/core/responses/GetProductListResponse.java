package lv.javaguru.java2.wasterestarant.core.responses;

import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

//Elena
public class GetProductListResponse {
    private List<Product> products;

    public GetProductListResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
