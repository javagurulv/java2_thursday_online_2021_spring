package lv.javaguru.java2.wasterestarant.core.database.order_item;

import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;

import java.util.Date;
import java.util.List;

public interface OrderItemRepository {

    void save(OrderItem orderItem);

    boolean deleteOrderItemByID(Long orderItemID);

    List<OrderItem> getAllOrderItems();

    List<OrderItem> searchOrderItemsByOrderID(Long orderID);

}
