package lv.javaguru.java2.wasterestarant.core.services.order;

import lv.javaguru.java2.wasterestarant.core.database.order.OrderRepository;
import lv.javaguru.java2.wasterestarant.core.services.order.validators.CreateNewOrderValidator;
import lv.javaguru.java2.wasterestarant.core.requests.order.CreateNewOrderRequest;
import lv.javaguru.java2.wasterestarant.core.domain.Order;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.order.CreateNewOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CreateNewOrderService {

    @Autowired
    private OrderRepository database;
    @Autowired
    private CreateNewOrderValidator validator;

    public CreateNewOrderResponse execute(CreateNewOrderRequest request) {

        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new CreateNewOrderResponse(errors);
        }

        Order order = new Order(request.getClientID(), request.getOrderDate());
        database.save(order);
        System.out.println("New order created");

        return new CreateNewOrderResponse(order);
    }
}
