package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.domain.Dish;

public interface Database {

    void save(Dish dish);

    void deleteByName(String name);

    void getDishByType(String dishType);

    void getAllDishes();



}
