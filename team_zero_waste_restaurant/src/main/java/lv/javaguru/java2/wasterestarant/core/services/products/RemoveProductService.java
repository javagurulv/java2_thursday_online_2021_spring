package lv.javaguru.java2.wasterestarant.core.services.products;


import lv.javaguru.java2.wasterestarant.core.database.product.ProductRepository;
import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.product.RemoveProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.validators.RemoveProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//AndrejsB
@Component
@Transactional
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
