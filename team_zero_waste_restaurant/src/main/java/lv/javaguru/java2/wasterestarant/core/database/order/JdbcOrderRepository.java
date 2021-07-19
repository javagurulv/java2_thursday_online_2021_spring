package lv.javaguru.java2.wasterestarant.core.database.order;

import lv.javaguru.java2.wasterestarant.core.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//@Component
public class JdbcOrderRepository implements OrderRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Order order) {
        jdbcTemplate.update(
                "INSERT INTO order_list(client_id, order_date)"
                        + "VALUES (?, ?)",
                order.getClientID(), order.getOrderDate()
        );

    }

    @Override
    public boolean deleteOrderByID(Long orderID) {
        String sql = "DELETE FROM order_list WHERE id = ?";
        Object[] args = new Object[]{orderID};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<Order> getAllOrders() {
        String sql = "SELECT * FROM order_list";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    @Override
    public List<Order> searchOrdersByClientID(Long clientID) {
        String sql = "SELECT * FROM dish WHERE client_ID = ?";
        Object[] args = new Object[] {clientID};
        return jdbcTemplate.query(sql, args, new OrderRowMapper());
    }

    @Override
    public List<Order> searchOrderByDate(Date orderDate) {
        String sql = "SELECT * FROM dish WHERE order_date = ?";
        Object[] args = new Object[] {orderDate};
        return jdbcTemplate.query(sql, args, new OrderRowMapper());
    }

    @Override
    public List<Order> searchOrderByClientIDAndDate(Long clientID, Date orderDate) {
        String sql = "SELECT * FROM dish WHERE client_ID = ? AND order_date = ?";
        Object[] args = new Object[] {clientID, orderDate};
        return jdbcTemplate.query(sql, args, new OrderRowMapper());
    }

    @Override
    public Optional<Order> getById(Long id) {
        return Optional.empty();
    }

}
