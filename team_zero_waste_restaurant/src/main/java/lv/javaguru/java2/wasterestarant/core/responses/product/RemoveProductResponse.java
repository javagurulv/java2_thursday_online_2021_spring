package lv.javaguru.java2.wasterestarant.core.responses.product;

import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

//AndrejsB
public class RemoveProductResponse extends CoreResponse {

    private boolean productNameToDelete;

    public RemoveProductResponse(List<CoreError> errors) {
        super(errors);
    }

    public RemoveProductResponse(boolean productNameToDelete) {
        this.productNameToDelete = productNameToDelete;
    }

    public boolean isProductRemoved() {
        return productNameToDelete;
    }
}
