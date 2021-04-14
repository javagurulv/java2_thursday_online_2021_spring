package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetProductListRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetProductListResponse;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

//Elena
public class GetProductListService {
    private Database database;

    public GetProductListService(Database database) {
        this.database = database;
    }

    public GetProductListResponse execute(GetProductListRequest request){
//        List<Product> products = new database.getAllProducts();
//        return new GetProductListResponse(products);
        return null;
    }
}
