package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.product.AddProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.AddProductResponse;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

public class AddProductService {
    private Database database;
    private AddProductValidator validator;

    public AddProductService(Database database, AddProductValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public AddProductResponse execute(AddProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddProductResponse(errors);
        }

        Product product = new Product(request.getName(), request.getQuantity(), request.getPrice(), request.getDate());
        database.save(product);
        System.out.println("New dish was added to the list.");

        return new AddProductResponse(product);
    }
}
