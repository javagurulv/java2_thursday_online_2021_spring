package database;

import domain.Dish;
import domain.Product;

import java.util.List;

public interface Database {

    void save(Dish dish);

    void deleteByName(String name);

    void getDishByType(String dishType);

    void getAllDishes();



}
