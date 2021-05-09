package lv.javaguru.java2.wasterestarant.core.services.order;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.order.GetAllOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetAllOrdersResponse;
import lv.javaguru.java2.wasterestarant.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllOrdersService {
    @Autowired
    private Database database;

    public GetAllOrdersResponse execute(GetAllOrdersRequest request) {
        List<Order> orders = database.getAllOrders();
        return new GetAllOrdersResponse(orders);
    }
}
