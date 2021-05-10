package lv.javaguru.java2.wasterestarant.core.requests.order;

//Nataliya

import lv.javaguru.java2.wasterestarant.core.domain.Client;

import java.util.Date;

public class CreateNewOrderRequest {

    private Long clientID;
    private Date orderDate;

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

}
