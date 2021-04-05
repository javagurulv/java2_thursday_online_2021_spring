package domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private Client client;
    private Date orderDate;
    private List<Dish> orderedDishes;

    public Order() { }

    public Order(Client client, Date orderDate, List<Dish> orderedDishes) {
        this.client = client;
        this.orderDate = orderDate;
        this.orderedDishes = orderedDishes;
    }

    public Client getClientName() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Dish> getOrderedDishes() {
        return orderedDishes;
    }

    public void setOrderedDishes(List<Dish> orderedDishes) {
        this.orderedDishes = orderedDishes;
    }

    @Override
    public String toString() {
        return "domain.Order{" +
                "clientName='" + client + '\'' +
                ", orderDate=" + orderDate +
                ", orderedDishes=" + orderedDishes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return client.equals(order.client) &&
                orderDate.equals(order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, orderDate);
    }
}
