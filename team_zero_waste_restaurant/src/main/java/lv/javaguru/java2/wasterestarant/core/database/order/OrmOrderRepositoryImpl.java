package lv.javaguru.java2.wasterestarant.core.database.order;

import lv.javaguru.java2.wasterestarant.core.domain.Order;
import lv.javaguru.java2.wasterestarant.core.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class OrmOrderRepositoryImpl implements OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public boolean deleteOrderByID(Long orderID) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE Order WHERE id = :id");
        query.setParameter("id", orderID);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<Order> getAllOrders() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Order b", Order.class)
                .getResultList();
    }

    @Override
    public List<Order> searchOrdersByClientID(Long clientID) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM Order b WHERE user_id = :user_id");
        query.setParameter("user_id", clientID);
        return query.getResultList();
    }

    @Override
    public List<Order> searchOrderByDate(Date orderDate) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM Order b WHERE order_date = :order_date");
        query.setParameter("order_date", orderDate);
        return query.getResultList();
    }

    @Override
    public List<Order> searchOrderByClientIDAndDate(Long clientID, Date orderDate) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM Order b WHERE order_date = :order_date AND user_id = :user_id");
        query.setParameter("order_date", orderDate);
        query.setParameter("user_id", clientID);
        return query.getResultList();
    }

    @Override
    public Optional<Order> getById(Long id) {
        Order order = sessionFactory.getCurrentSession().get(Order.class, id);
        if (order == null) {
            return Optional.empty();
        } else {
            return Optional.of(order);
        }
    }

}
