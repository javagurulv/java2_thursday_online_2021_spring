package lv.javaguru.java2.wasterestarant.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_order_items")
public class OrderOrderItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItem orderItem;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OrderOrderItem that = (OrderOrderItem) o;
        return Objects.equals(id, that.id) && Objects.equals(order, that.order) && Objects
                .equals(orderItem, that.orderItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, orderItem);
    }

    @Override
    public String toString() {
        return "OrderOrderItem{" +
                "id=" + id +
                ", order=" + order +
                ", orderItem=" + orderItem +
                '}';
    }

}
