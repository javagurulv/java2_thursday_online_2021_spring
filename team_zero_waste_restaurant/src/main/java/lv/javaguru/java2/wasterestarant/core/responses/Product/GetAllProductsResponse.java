package lv.javaguru.java2.wasterestarant.core.responses.Product;

import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

//Elena
public class GetAllProductsResponse {
    private List<Product> products;

    public GetAllProductsResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
