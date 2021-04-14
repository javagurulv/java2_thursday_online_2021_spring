package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

public interface Database {

    void save(Dish dish);

    boolean deleteByNameBool(String name);

    List<Dish> getAllDishes();

    //List<Product> getAllProducts();

    List<Dish> dishByType(String dishType);

}
