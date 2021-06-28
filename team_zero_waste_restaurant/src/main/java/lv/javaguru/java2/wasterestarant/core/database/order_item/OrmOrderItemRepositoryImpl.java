package lv.javaguru.java2.wasterestarant.core.database.order_item;

import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class OrmOrderItemRepositoryImpl implements OrderItemRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(OrderItem orderItem) {
        sessionFactory.getCurrentSession().save(orderItem);
    }

    @Override
    public boolean deleteOrderItemByID(Long orderItemID) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE OrderItem WHERE id = :id");
        query.setParameter("id", orderItemID);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM OrderItem b", OrderItem.class)
                .getResultList();
    }

    @Override
    public List<OrderItem> searchOrderItemsByOrderID(Long orderID) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT b FROM OrderItem b WHERE order_id = :order_id");
        query.setParameter("order_id", orderID);
        return query.getResultList();
    }

}
