import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Order {

    private String clientName;
    private Date orderDate;
    private List<Dish> orderedDishes;

    public Order() { }

    public Order(String clientName, Date orderDate, List<Dish> orderedDishes) {
        this.clientName = clientName;
        this.orderDate = orderDate;
        this.orderedDishes = orderedDishes;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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
        return "Order{" +
                "clientName='" + clientName + '\'' +
                ", orderDate=" + orderDate +
                ", orderedDishes=" + orderedDishes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return clientName.equals(order.clientName) &&
                orderDate.equals(order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, orderDate);
    }
}
