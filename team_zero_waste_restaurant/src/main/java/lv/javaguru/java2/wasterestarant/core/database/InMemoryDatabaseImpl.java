package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.domain.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public boolean deleteByNameBool(String name) {
        boolean isDishDeleted = false;
        Optional<Dish> dishToDeleteTool = dishes.stream()
                .filter(dish -> dish.getName().equals(name))
                .findFirst();
        if (dishToDeleteTool.isPresent()) {
            Dish dishToDelete = dishToDeleteTool.get();
            isDishDeleted = dishes.remove(dishToDelete);
        }
        return isDishDeleted;
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



