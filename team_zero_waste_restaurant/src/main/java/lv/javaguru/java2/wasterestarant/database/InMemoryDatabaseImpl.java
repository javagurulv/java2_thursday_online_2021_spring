package lv.javaguru.java2.wasterestarant.database;

import lv.javaguru.java2.wasterestarant.domain.Dish;

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
    public void getAllDishes() {
        for (int i = 0; i < dishes.size(); i++) {
            printDishWithFields(dishes, i);
        }
    }

    @Override
    public void getDishByType(String dishType) {
        List<Dish> sortedList = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getType().equals(dishType)) {
                sortedList.add(dish);
            } else {
                System.out.println("This dish type not found.");
            }
        }
        for (int i = 0; i < sortedList.size(); i++) {
            printDishWithFields(sortedList, i);
        }
    }

    private void printDishWithFields(List<Dish> sortedList, int i) {
        System.out.println((i + 1) + ". " + sortedList.get(i).getName() +
                ", " + sortedList.get(i).getDescription() +
                //", " + sortedList.get(i).getProductList() +
                ", " + sortedList.get(i).getType() +
                ", price - " + sortedList.get(i).getPrice() + " \u0024, " +
                "weight - " + sortedList.get(i).getWeight() + " grams.");
    }
}



