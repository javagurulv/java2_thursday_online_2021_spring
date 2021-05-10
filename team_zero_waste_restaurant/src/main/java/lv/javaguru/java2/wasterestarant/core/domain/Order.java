package lv.javaguru.java2.wasterestarant.core.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private Long orderID;
    private Long clientID;
    private Date orderDate;
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(Long clientID, Date orderDate, List<OrderItem> orderItems) {
        this.clientID = clientID;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderedDishes(List<Dish> orderedDishes) {
        this.orderItems = orderItems;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", client=" + clientID +
                ", orderDate=" + orderDate +
                ", orderItems=" + orderItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderID == order.orderID &&
                clientID.equals(order.clientID) &&
                orderDate.equals(order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, clientID, orderDate);
    }
}
