package lv.javaguru.java2.wasterestarant.core.services.products;


import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.product.RemoveProductResponse;
import java.util.List;

//AndrejsB
public class RemoveProductService {

    private Database database;
    private RemoveProductValidator validator;

    public RemoveProductService(Database database, RemoveProductValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public RemoveProductResponse execute (RemoveProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if(!errors.isEmpty()){
            return new RemoveProductResponse(errors);
        }
        boolean isProductDeleted = database.deleteProductByName(request.getProductNameToRemove());
        return new RemoveProductResponse(isProductDeleted);
    }

}
