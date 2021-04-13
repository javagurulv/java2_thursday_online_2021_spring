package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.List;

public interface Database {

    void save(Dish dish);

    boolean deleteByNameBool(String name);

    List<Dish> getAllDishes();

    List<Dish> dishByType(String dishType);

}
