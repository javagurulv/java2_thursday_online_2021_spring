package lv.javaguru.java2.wasterestarant.core.database.order_item;

import lv.javaguru.java2.wasterestarant.core.database.order.OrderRowMapper;
import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class JdbcOrderItemRepository implements OrderItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(OrderItem orderItem) {
        jdbcTemplate.update(
                "INSERT INTO order_item(order_id, dish_id, quantity)"
                        + "VALUES (?, ?, ?)",
                orderItem.getOrderID(), orderItem.getDishID(), orderItem.getQuantity()
        );
    }

    @Override
    public boolean deleteOrderItemByID(Long orderItemID) {
        String sql = "DELETE FROM order_item WHERE id = ?";
        Object[] args = new Object[]{orderItemID};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return null;
    }

    @Override
    public List<OrderItem> searchOrderItemsByOrderID(Long orderID) {
        String sql = "SELECT * FROM order_item";
        return jdbcTemplate.query(sql, new OrderItemRowMapper());
    }

}
