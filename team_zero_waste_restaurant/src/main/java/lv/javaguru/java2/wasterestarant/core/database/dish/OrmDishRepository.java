package lv.javaguru.java2.wasterestarant.core.database.dish;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class OrmDishRepository implements DishRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Dish dish) {
        sessionFactory.getCurrentSession().save(dish);
    }

    @Override
    public boolean deleteDishByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE Dish " +
                "WHERE name = :name");
        query.setParameter("name", name);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public List<Dish> getAllDishes() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT d from Dish d", Dish.class)
                .getResultList();
    }

    @Override
    public List<Dish> findDishByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT d FROM Dish WHERE name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Dish> findDishByType(String type) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT d FROM Dish WHERE type = :type");
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public List<Dish> findDishByPrice(Double price) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT d FROM Dish WHERE price = :price");
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Dish> findDishByNameAndType(String name, String type) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT d FROM Dish WHERE name = :name AND type = :type");
        query.setParameter("name", name);
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public List<Dish> findDishByNameAndPrice(String name, Double price) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT d FROM Dish WHERE name = :name AND price = :price");
        query.setParameter("name", name);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Dish> findDishByTypeAndPrice(String type, Double price) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT d FROM Dish WHERE type = :type AND price = :price");
        query.setParameter("type", type);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Dish> findDishByNameAndTypeAndPrice(String name, String type, Double price) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT d FROM Dish WHERE name = :name AND type = :type AND price = :price");
        query.setParameter("name", name);
        query.setParameter("type", type);
        query.setParameter("price", price);
        return query.getResultList();
    }
}