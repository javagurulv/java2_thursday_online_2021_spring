package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

//Elena
public class GetAllProductsService {
    private Database database;

    public GetAllProductsService(Database database) {
        this.database = database;
    }

    public GetAllProductsResponse execute(GetAllProductsRequest request){
        List<Product> products = database.getAllProducts();
        return new GetAllProductsResponse(products);
    }
}
