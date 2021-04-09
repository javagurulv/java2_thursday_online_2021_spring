package database;

import domain.Dish;

public interface Database {

    void save(Dish dish);

    void deleteByName(String name);

    void getDishByType(String dishType);

    void getAllDishes();



}
