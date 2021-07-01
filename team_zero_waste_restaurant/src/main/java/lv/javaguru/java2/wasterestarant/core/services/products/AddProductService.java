package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.product.ProductRepository;
import lv.javaguru.java2.wasterestarant.core.requests.product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.AddProductResponse;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.domain.Product;
import lv.javaguru.java2.wasterestarant.core.services.products.validators.AddProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddProductService {
    @Autowired
    private ProductRepository database;
    @Autowired private AddProductValidator validator;

    public AddProductResponse execute(AddProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddProductResponse(errors);
        }

        Product product = new Product(request.getName(), request.getQuantity(), request.getPrice(), request.getDate());
        database.save(product);
        System.out.println("New product was added to the list.");

        return new AddProductResponse(product);
    }
}
