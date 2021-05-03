package lv.javaguru.java2.wasterestarant.core.services.products;


import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.product.RemoveProductResponse;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;

import java.util.List;

//AndrejsB
@DIComponent
public class RemoveProductService {

    @DIDependency
    private Database database;
    @DIDependency
    private RemoveProductValidator validator;

    public RemoveProductResponse execute(RemoveProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveProductResponse(errors);
        }
        boolean isProductDeleted = database.deleteProductByName(request.getProductNameToRemove());
        return new RemoveProductResponse(isProductDeleted);
    }

}
