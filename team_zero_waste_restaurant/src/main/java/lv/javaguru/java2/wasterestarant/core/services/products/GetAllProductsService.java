package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.product.GetAllProductsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.GetAllProductsResponse;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

//Elena
@DIComponent
public class GetAllProductsService {
    @DIDependency
    private Database database;

    public GetAllProductsResponse execute(GetAllProductsRequest request) {
        List<Product> products = database.getAllProducts();
        return new GetAllProductsResponse(products);
    }
}
