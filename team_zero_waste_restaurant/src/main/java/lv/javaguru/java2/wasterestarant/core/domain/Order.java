package lv.javaguru.java2.wasterestarant.core.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//@Entity
@Table(name = "order_list")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    @Column(name = "client_id")
    private Long clientID;

    @Column(name = "order_date")
    private Date orderDate;

    //private List<OrderItem> wishlist;

    public Order() {

    }

    public Order(Long clientID, Date orderDate) {
        this.clientID = clientID;
        this.orderDate = orderDate;
    }

    public Order(long clientID, Date orderDate/*, List<OrderItem> wishlist*/) {
        this.clientID = clientID;
        this.orderDate = orderDate;
        //this.wishlist = wishlist;
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

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }


  /*  public List<OrderItem> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<OrderItem> wishlist) {
        this.wishlist = wishlist;
    }
*/

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", client=" + clientID +
                ", orderDate=" + orderDate +
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
