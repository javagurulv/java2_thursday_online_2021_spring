package lv.javaguru.java2.wasterestarant.core.requests.order;

//Nataliya

import java.util.Date;

public class CreateNewOrderRequest {

    private Long clientID;
    private Date orderDate;

    public CreateNewOrderRequest(Long clientID, Date orderDate) {
        this.clientID = clientID;
        this.orderDate = orderDate;
    }

    public CreateNewOrderRequest() {

    }

    public Long getClientID() {
        return clientID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
