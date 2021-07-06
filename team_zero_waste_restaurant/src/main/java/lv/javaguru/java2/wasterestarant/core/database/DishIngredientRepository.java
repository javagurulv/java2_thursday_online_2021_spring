//package lv.javaguru.java2.wasterestarant.core.database;
//
//
//import lv.javaguru.java2.wasterestarant.core.domain.DishIngredient;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.transaction.Transactional;
//
//@Component
//@Transactional
//public class DishIngredientRepository {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public DishIngredient getById(Long id){
//        return sessionFactory.getCurrentSession()
//                .get(DishIngredient.class, id);
//    }
//}
