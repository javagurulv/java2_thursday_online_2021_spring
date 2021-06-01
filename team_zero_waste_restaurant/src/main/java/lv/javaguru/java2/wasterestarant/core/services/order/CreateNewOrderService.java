package lv.javaguru.java2.wasterestarant.core.services.order;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.order.CreateNewOrderRequest;
import lv.javaguru.java2.wasterestarant.core.domain.Order;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.order.CreateNewOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateNewOrderService {
    @Autowired
    private Database database;
    @Autowired
    private CreateNewOrderValidator validator;

    public CreateNewOrderResponse execute(CreateNewOrderRequest request) {

        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new CreateNewOrderResponse(errors);
        }

        Order order = new Order(request.getClientID(), request.getOrderDate(), request.getOrderItems());
        database.save(order);
        System.out.println("New order created");

        return new CreateNewOrderResponse(order);
    }
}
