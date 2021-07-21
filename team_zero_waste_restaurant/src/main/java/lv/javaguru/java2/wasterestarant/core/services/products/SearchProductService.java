package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.product.ProductRepository;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.product.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.product.SearchProductResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Product;
import lv.javaguru.java2.wasterestarant.core.services.products.validators.SearchProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class SearchProductService {

    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;
    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired
    private ProductRepository database;
    @Autowired
    private SearchProductValidator validator;

    public SearchProductResponse execute(SearchProductRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchProductResponse(errors, null);
        }
        List<Product> products = search(request);
        products = order(products, request.getOrdering());
        products = paging(products, request.getPaging());
        return new SearchProductResponse(null, products);
    }

    private List<Product> order(List<Product> products, Ordering ordering) {
        if (orderingEnabled && (ordering != null)) {
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

    private List<Product> paging(List<Product> products, Paging paging) {
        if (pagingEnabled && (paging != null)) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return products.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return products;
        }
    }
}
