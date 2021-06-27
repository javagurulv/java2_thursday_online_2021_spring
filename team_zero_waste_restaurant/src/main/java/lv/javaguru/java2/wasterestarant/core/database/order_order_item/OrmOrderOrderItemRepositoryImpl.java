package lv.javaguru.java2.wasterestarant.core.database.order_order_item;

import lv.javaguru.java2.wasterestarant.core.domain.OrderOrderItem;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OrmOrderOrderItemRepositoryImpl implements OrderOrderItemRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(OrderOrderItem orderOrderItem) {
        sessionFactory.getCurrentSession().save(orderOrderItem);
    }

    public OrderOrderItem getById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(OrderOrderItem.class, id);
    }


}
