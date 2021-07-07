package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.product.ProductRepository;
import lv.javaguru.java2.wasterestarant.core.requests.product.GetProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.product.GetProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.validators.GetProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired private GetProductValidator validator;

    public GetProductResponse execute(GetProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetProductResponse(errors);
        }
        return productRepository.getProductById(request.getId())
                .map(GetProductResponse::new)
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new GetProductResponse(errors); });
    }

}