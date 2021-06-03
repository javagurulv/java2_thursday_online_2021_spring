package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.database.Product.ProductDatabase;
import lv.javaguru.java2.wasterestarant.core.requests.product.GetAllProductsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.product.GetAllProductsResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//Elena
@Component
public class GetAllProductsService {
    @Autowired
    private ProductDatabase database;

    public GetAllProductsResponse execute(GetAllProductsRequest request) {
        List<Product> products = database.getAllProducts();
        return new GetAllProductsResponse(products);
    }
}
