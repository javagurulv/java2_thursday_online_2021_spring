package lv.javaguru.java2.wasterestarant.core.services.order;

import lv.javaguru.java2.wasterestarant.core.database.order.OrderRepository;
import lv.javaguru.java2.wasterestarant.core.requests.order.GetAllOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetAllOrdersResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAllOrdersService {
    @Autowired
    private OrderRepository database;

    public GetAllOrdersResponse execute(GetAllOrdersRequest request) {
        List<Order> orders = database.getAllOrders();
        return new GetAllOrdersResponse(orders);
    }
}
