package lv.javaguru.java2.wasterestarant.core.responses.order;

import lv.javaguru.java2.wasterestarant.core.domain.Order;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.CoreResponse;

import java.util.List;

public class CreateNewOrderResponse extends CoreResponse {

    private Order newOrder;

    public CreateNewOrderResponse(List<CoreError> errors) {
        super(errors);
    }

    public CreateNewOrderResponse(Order newOrder) {
        this.newOrder = newOrder;
    }

    public Order getNewOrder() {
        return newOrder;
    }

}
