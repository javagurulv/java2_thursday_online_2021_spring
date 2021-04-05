package database;

import domain.Dish;

import java.util.List;

public interface Database {

    void save(Dish dish);

    void deleteByName(String name);

    List<Dish> getAllDishes();

}
