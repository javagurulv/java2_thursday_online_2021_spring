package lv.javaguru.java2.wasterestarant.core.responses.product;

import lv.javaguru.java2.wasterestarant.core.domain.Product;

import java.util.List;

public class GetAllProductsResponse {
    private List<Product> products;

    public GetAllProductsResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
