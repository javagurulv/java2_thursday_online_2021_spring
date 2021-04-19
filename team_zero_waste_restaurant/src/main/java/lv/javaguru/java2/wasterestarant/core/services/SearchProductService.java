package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

public class SearchProductService {

    private Database database;
    private SearchProductServiceValidator validator;

    public SearchProductService(Database database, SearchProductServiceValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchProductResponse execute(SearchProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()){
            return new SearchProductResponse(errors, null);
        }
        List<Product> products = null;

        if(request.isNameProvided()){
            products = database.searchProductByName(request.getNameToSearch());
        }
        return new SearchProductResponse(null, products);
    }
}
