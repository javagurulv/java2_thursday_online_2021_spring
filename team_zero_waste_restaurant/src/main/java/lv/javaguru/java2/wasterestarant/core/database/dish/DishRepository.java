package lv.javaguru.java2.wasterestarant.core.database.dish;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;

import java.util.List;
import java.util.Optional;

//AndrejsB
public interface DishRepository {

    void save(Dish dish);

    boolean deleteDishByName(String name);

    List<Dish> getAllDishes();

    List<Dish> getAllDishesInActiveMenu(boolean isInActiveMenu);

    Optional<Dish> getById(Long id);

    List<Dish> findDishByName(String name);

    List<Dish> findDishByType(String type);

    List<Dish> findDishByPrice(Double price);

    List<Dish> findDishByNameAndType(String name, String type);

    List<Dish> findDishByNameAndPrice(String name, Double price);

    List<Dish> findDishByTypeAndPrice(String type, Double price);

    List<Dish> findDishByNameAndTypeAndPrice(String name, String type, Double price);


}
