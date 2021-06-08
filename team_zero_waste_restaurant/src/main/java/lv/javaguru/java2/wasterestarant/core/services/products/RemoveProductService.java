package lv.javaguru.java2.wasterestarant.core.services.products;


import lv.javaguru.java2.wasterestarant.core.database.Product.ProductRepository;
import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.product.RemoveProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//AndrejsB
@Component
public class RemoveProductService {

    @Autowired
    private ProductRepository database;
    @Autowired
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
