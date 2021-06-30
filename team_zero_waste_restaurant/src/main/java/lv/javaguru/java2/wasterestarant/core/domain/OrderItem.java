package lv.javaguru.java2.wasterestarant.core.domain;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemID;

    @Column(name = "order_id")
    private Long orderID;

    @Column(name = "dish_id")
    private Long dishID;

    @Column(name = "quantity")
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(Long orderID, Long dishID, int quantity) {
        this.orderID = orderID;
        this.dishID = dishID;
        this.quantity = quantity;
    }

    public Long getDishID() {
        return dishID;
    }

    public void setDishID(Long dishID) {
        this.dishID = dishID;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                ", orderID='" + orderID + '\'' +
                ", dishID='" + dishID + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
