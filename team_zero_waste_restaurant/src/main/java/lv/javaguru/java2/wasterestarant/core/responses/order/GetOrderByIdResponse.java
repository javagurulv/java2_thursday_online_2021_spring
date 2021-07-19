package lv.javaguru.java2.wasterestarant.core.responses.order;

import lv.javaguru.java2.wasterestarant.core.domain.Order;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class GetOrderByIdResponse extends CoreResponse {

    private Order order;

    public GetOrderByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetOrderByIdResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

}
