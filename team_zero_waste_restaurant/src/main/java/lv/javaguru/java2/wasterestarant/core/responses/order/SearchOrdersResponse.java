package lv.javaguru.java2.wasterestarant.core.responses.order;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import lv.javaguru.java2.wasterestarant.core.domain.Order;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class SearchOrdersResponse extends CoreResponse {

    private List<Order> orders;

    public SearchOrdersResponse(List<Order> orders, List<CoreError> errors) {
        super(errors);
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
