package lv.javaguru.java2.wasterestarant.core.database.order;

import lv.javaguru.java2.wasterestarant.core.domain.Order;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setOrderID(rs.getLong("id"));
        order.setClientID(rs.getLong("user_id"));
        order.setOrderDate(rs.getDate("order_date"));
        return order;
    }

}
