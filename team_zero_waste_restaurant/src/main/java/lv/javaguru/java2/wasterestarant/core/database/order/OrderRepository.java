package lv.javaguru.java2.wasterestarant.core.database.order;

import lv.javaguru.java2.wasterestarant.core.domain.Order;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    void save(Order order);

    boolean deleteOrderByID(Long orderID);

    List<Order> getAllOrders();

    List<Order> searchOrdersByClientID(Long clientID);

    List<Order> searchOrderByDate(Date orderDate);

    List<Order> searchOrderByClientIDAndDate(Long clientID, Date orderDate);

    public Optional<Order> getById(Long id);

}
