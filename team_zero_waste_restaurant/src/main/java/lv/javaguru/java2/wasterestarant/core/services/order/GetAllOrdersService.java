package lv.javaguru.java2.wasterestarant.core.services.order;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.order.GetAllOrdersRequest;
import lv.javaguru.java2.wasterestarant.core.responses.order.GetAllOrdersResponse;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIComponent;
import lv.javaguru.java2.wasterestarant.dependency_injection.DIDependency;
import lv.javaguru.java2.wasterestarant.domain.Order;

import java.util.List;

@DIComponent
public class GetAllOrdersService {
    @DIDependency
    private Database database;

    public GetAllOrdersResponse execute(GetAllOrdersRequest request) {
        List<Order> orders = database.getAllOrders();
        return new GetAllOrdersResponse(orders);
    }
}
