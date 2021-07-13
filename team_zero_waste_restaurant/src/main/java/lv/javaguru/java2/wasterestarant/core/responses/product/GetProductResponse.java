package lv.javaguru.java2.wasterestarant.core.responses.product;

import lv.javaguru.java2.wasterestarant.core.domain.Product;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class GetProductResponse extends CoreResponse {

    private Product product;

    public GetProductResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

}
