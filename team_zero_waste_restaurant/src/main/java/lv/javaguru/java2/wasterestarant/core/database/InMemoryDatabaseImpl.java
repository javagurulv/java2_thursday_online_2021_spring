package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryDatabaseImpl implements Database {
    private Long nextId = 1L;
    private List<Dish> dishes = new ArrayList<>();
    private List<Dish> restaurantMenu = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    @Override
    public void save(Dish dish) {
        dish.setDishID(nextId);
        nextId++;
        dishes.add(dish);
    }

    @Override
    public void save(Product product) {
        product.setProductID(nextId);
        nextId++;
        products.add(product);
    }

    @Override
    public boolean deleteDishByName(String name) {
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
    public boolean deleteDishByID(Long dishID) {
        return false;
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishes;
    }

    @Override
    public List<Dish> findDishByName(String name) {
        return dishes.stream()
                .filter(dish -> dish.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dish> findDishByType(String type) {
        return dishes.stream()
                .filter(dish -> dish.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dish> findDishByPrice(Double price) {
        return dishes.stream()
                .filter(dish -> dish.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Dish> findDishByNameAndType(String name, String type) {
        return dishes.stream()
                .filter(dish -> dish.getName().equals(name))
                .filter(dish -> dish.getType().equals(type))
                .collect(Collectors.toList());
    }

    @Override
    public List<Dish> findDishByNameAndPrice(String name, Double price) {
        return dishes.stream()
                .filter(dish -> dish.getName().equals(name))
                .filter(dish -> dish.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Dish> findDishByTypeAndPrice(String type, Double price) {
        return dishes.stream()
                .filter(dish -> dish.getType().equals(type))
                .filter(dish -> dish.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Dish> findDishByNameAndTypeAndPrice(String name, String type, Double price) {
        return dishes.stream()
                .filter(dish -> dish.getName().equals(name))
                .filter(dish -> dish.getType().equals(type))
                .filter(dish -> dish.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public List<Dish> getRestaurantMenu() {
        return restaurantMenu;
    }

    @Override
    public List<Dish> getWishList() {
        return null;
    }

    @Override
    public List<Dish> getDishByType(String dishType) {
        List<Dish> dishByType = dishes.stream()
                .filter(dish -> dish.getType().equals(dishType))
                .collect(Collectors.toList());
        return dishByType;
    }
}



