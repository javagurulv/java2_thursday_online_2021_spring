package lv.javaguru.java2.wasterestarant.core.requests.order;

import java.util.Date;

public class SearchOrdersRequest {

    private Long clientID;
    private Date orderDate;

    public SearchOrdersRequest() {
    }

    public SearchOrdersRequest(Long clientID) {
        this.clientID = clientID;
    }

    public SearchOrdersRequest(Date orderDate) {
        this.orderDate = orderDate;
    }

    public SearchOrdersRequest(Long clientID, Date orderDate) {
        this.clientID = clientID;
        this.orderDate = orderDate;
    }

    public Long getClientID() {
        return clientID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public boolean isClientIDProvided() {
        return this.clientID != null;
    }

    public boolean isOrderDateProvided() {
        return this.orderDate != null;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
