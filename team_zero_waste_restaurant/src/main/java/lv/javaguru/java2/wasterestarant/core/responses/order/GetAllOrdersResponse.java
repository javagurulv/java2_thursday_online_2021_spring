package lv.javaguru.java2.wasterestarant.core.responses.order;

import lv.javaguru.java2.wasterestarant.core.domain.Order;

import java.util.List;

public class GetAllOrdersResponse {

    private List<Order> orders;

    public GetAllOrdersResponse(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
