package lv.javaguru.java2.wasterestarant.core.database.order_item;

import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemRowMapper implements RowMapper<OrderItem> {

    @Override
    public OrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderID(rs.getLong("order_id"));
        orderItem.setDishID(rs.getLong("dish_id"));
        orderItem.setQuantity(rs.getInt("quantity"));
        return orderItem;
    }
}
