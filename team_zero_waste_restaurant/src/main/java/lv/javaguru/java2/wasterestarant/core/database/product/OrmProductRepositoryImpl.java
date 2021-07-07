package lv.javaguru.java2.wasterestarant.core.database.product;

import lv.javaguru.java2.wasterestarant.core.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class OrmProductRepositoryImpl implements ProductRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public boolean deleteProductByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE Product WHERE name = :name");
        query.setParameter("name", name);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM Product b", Product.class)
                .getResultList();
    }

    @Override
    public List<Product> searchProductByName(String name) {
        Query query = sessionFactory. getCurrentSession().createQuery(
                "SELECT b FROM Product b WHERE name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Product product = sessionFactory.getCurrentSession().get(Product.class, id);
        if (product == null) {
            return Optional.empty();
        } else {
            return Optional.of(product);
        }
    }

}
