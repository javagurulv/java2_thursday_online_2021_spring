package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.List;

public interface Database {

    void save(Dish dish);

    void save(Product product);

    boolean deleteDishByName(String name);

    boolean deleteDishByID(Long dishID);

    List<Dish> getAllDishes();

    List<Dish> findDishByName(String name);

    List<Dish> findDishByType(String type);

    List<Dish> findDishByPrice(Double price);

    List<Product> getAllProducts();

    List<Dish> getRestaurantMenu();

    List<Dish> getWishList(); // is wish list stored in database?

    List<Dish> getDishByType(String dishType);

}
