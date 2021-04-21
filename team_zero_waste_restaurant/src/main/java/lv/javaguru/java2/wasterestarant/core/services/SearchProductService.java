package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProductService {

    private Database database;
    private SearchProductServiceValidator validator;

    public SearchProductService(Database database, SearchProductServiceValidator validator) {
        this.database = database;
        this.validator = validator;
    }

    public SearchProductResponse execute(SearchProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchProductResponse(errors, null);
        }
        List<Product> products = search(request);
        products = order(products, request.getOrdering());
        return new SearchProductResponse(null, products);
    }

    private List<Product> order(List<Product> products, Ordering ordering) {
        if (ordering != null) {
            Comparator<Product> comparator = ordering.getOrderBy().equals("BBD")
                    ? Comparator.comparing(Product::getExpiryDate)
                    : Comparator.comparing(Product::getQuantity);
            if (ordering.getOrderDirection().equals("DESC")) {
                comparator = comparator.reversed();
            }
            return products.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return products;
        }
    }

    private List<Product> search(SearchProductRequest request) {
        List<Product> products = new ArrayList<>();
        if (request.isNameProvided()) {
            products = database.searchProductByName(request.getNameToSearch());
        }
        return products;
    }
}
