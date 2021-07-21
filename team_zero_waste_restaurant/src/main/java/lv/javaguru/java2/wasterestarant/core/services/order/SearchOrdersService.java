package lv.javaguru.java2.wasterestarant.core.services.order;

import lv.javaguru.java2.wasterestarant.core.database.order.OrderRepository;
import lv.javaguru.java2.wasterestarant.core.domain.Order;
import lv.javaguru.java2.wasterestarant.core.services.order.validators.SearchOrdersRequestValidator;
import lv.javaguru.java2.wasterestarant.core.requests.order.SearchOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.order.SearchOrdersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class SearchOrdersService {

    @Autowired
    private OrderRepository database;
    @Autowired
    private SearchOrdersRequestValidator validator;

    public SearchOrdersResponse execute(SearchOrdersRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchOrdersResponse(null, errors);
        }

        List<Order> orders = search(request);
        return new SearchOrdersResponse(orders, null);
    }

    private List<Order> search(SearchOrdersRequest request) {

        List<Order> orders = new ArrayList<>();
        if (request.isClientIDProvided() && !request.isOrderDateProvided()) {
            orders = database.searchOrdersByClientID(request.getClientID());
        }
        if (!request.isClientIDProvided() && request.isOrderDateProvided()) {
            orders = database.searchOrderByDate(request.getOrderDate());
        }
        if (request.isClientIDProvided() && request.isOrderDateProvided()) {
            orders = database.searchOrderByClientIDAndDate(request.getClientID(), request.getOrderDate());
        }

        return orders;
    }
}
