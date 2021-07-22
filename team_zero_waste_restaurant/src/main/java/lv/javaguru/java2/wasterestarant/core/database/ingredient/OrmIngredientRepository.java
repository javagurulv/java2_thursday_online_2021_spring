package lv.javaguru.java2.wasterestarant.core.database.ingredient;

import lv.javaguru.java2.wasterestarant.core.domain.DishIngredient;
import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class OrmIngredientRepository implements IngredientRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Ingredient ingredient) {
        sessionFactory.getCurrentSession().save(ingredient);
    }

    @Override
    public List<Ingredient> findIngredientByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT i FROM Ingredient i WHERE name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<DishIngredient> findIngredientByDishId(Long dish_id) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT i FROM Ingredient i JOIN Dish d ON i.dishIngredientID = d.id" +
                        " WHERE dish_id =  :dish_id");
        query.setParameter("dish_id", dish_id);
        return query.getResultList();
    }

}
