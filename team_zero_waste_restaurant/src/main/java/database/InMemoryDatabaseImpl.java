package database;

import domain.Dish;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabaseImpl implements Database {

    private List<Dish> dishes = new ArrayList<>();


    @Override
    public void save(Dish dish) {
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

}
