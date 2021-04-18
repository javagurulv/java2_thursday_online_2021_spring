package lv.javaguru.java2.wasterestarant.domain;

import java.util.Objects;

//Nataliya

public class OrderItem {

    private Long orderId;
    private String name;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderId.equals(orderItem.orderId) &&
                name.equals(orderItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, name);
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
