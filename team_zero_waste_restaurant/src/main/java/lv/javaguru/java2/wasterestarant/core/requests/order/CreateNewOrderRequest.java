package lv.javaguru.java2.wasterestarant.core.requests.order;

//Nataliya

import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;

import java.util.Date;
import java.util.List;

public class CreateNewOrderRequest {

    private Long clientID;
    private Date orderDate;
    private List<OrderItem> orderItems;

    public CreateNewOrderRequest(Long clientID, Date orderDate) {
        this.clientID = clientID;
        this.orderDate = orderDate;
    }

    public Long getClientID() {
        return clientID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
