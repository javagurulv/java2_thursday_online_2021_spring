package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements Database {
    private Long nextId = 1L;
    private List<Dish> dishes = new ArrayList<>();
    private List<Dish> dishByType = new ArrayList<>();

    @Override
    public void save(Dish dish) {
        dish.setDishID(nextId);
        nextId++;
        dishes.add(dish);
    }

    @Override
    public void deleteByName(String name) {
        dishes.stream()
                .filter(dish -> dish.getName().equals(name))
                .findFirst()
                .ifPresent(dish -> dishes.remove(dish));
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishes;
    }

    @Override
    public List<Dish> dishByType(String dishType) {
       dishes.stream()
                 .filter(dish -> dish.getType().equals(dishType))
                 .findFirst()
                 .ifPresent(dish -> dishByType.add(dish));
        return dishByType;
    }
}



