package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.core.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component
public class InMemoryDatabaseImpl implements Database {
    private Long nextDishId = 1L;
    private Long nextProductId = 1L;
    private Long nextClientId = 1L;
    private Long nextOrderId = 1L;
    private List<Dish> dishes = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

//    @Override
//    public void save(Dish dish) {
//        dish.setDishID(nextDishId);
//        nextDishId++;
//        dishes.add(dish);
//    }


//    @Override
//    public void save(Ingredient ingredient) {
//        ingredients.add(ingredient);
//
//    }

    @Override
    public void save(User user) {
        user.setId(nextClientId);
        nextClientId++;
        users.add(user);
    }

//    @Override
//    public void save(Order order) {
//        order.setOrderID(nextOrderId);
//        nextOrderId++;
//        orders.add(order);
//    }

//    @Override
//    public boolean deleteDishByName(String name) {
//        boolean isDishDeleted = false;
//        Optional<Dish> dishToDeleteTool = dishes.stream()
//                .filter(dish -> dish.getName().equals(name))
//                .findFirst();
//        if (dishToDeleteTool.isPresent()) {
//            Dish dishToDelete = dishToDeleteTool.get();
//            isDishDeleted = dishes.remove(dishToDelete);
//        }
//        return isDishDeleted;
//    }


//    @Override
//    public boolean deleteDishByID(Long dishID) {
//        return false;
//    }

//    @Override
//    public List<Ingredient> findIngredientByName(String name) {
//        return ingredients.stream()
//                .filter(ingredient -> ingredient.getIngredient().equals(name))
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<Dish> getAllDishes() {
//        return dishes;
//    }

//    @Override
//    public List<Dish> findDishByName(String name) {
//        return dishes.stream()
//                .filter(dish -> dish.getName().equals(name))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Dish> findDishByType(String type) {
//        return dishes.stream()
//                .filter(dish -> dish.getType().equals(type))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Dish> findDishByPrice(Double price) {
//        return dishes.stream()
//                .filter(dish -> dish.getPrice() == price)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Dish> findDishByNameAndType(String name, String type) {
//        return dishes.stream()
//                .filter(dish -> dish.getName().equals(name))
//                .filter(dish -> dish.getType().equals(type))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Dish> findDishByNameAndPrice(String name, Double price) {
//        return dishes.stream()
//                .filter(dish -> dish.getName().equals(name))
//                .filter(dish -> dish.getPrice() == price)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Dish> findDishByTypeAndPrice(String type, Double price) {
//        return dishes.stream()
//                .filter(dish -> dish.getType().equals(type))
//                .filter(dish -> dish.getPrice() == price)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Dish> findDishByNameAndTypeAndPrice(String name, String type, Double price) {
//        return dishes.stream()
//                .filter(dish -> dish.getName().equals(name))
//                .filter(dish -> dish.getType().equals(type))
//                .filter(dish -> dish.getPrice() == price)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<Dish> getRestaurantMenu() {
        return dishes.stream()
                .filter(dish -> dish.isInActiveMenu())
                .collect(Collectors.toList());
    }


    @Override
    public Optional<User> clientByID(Long clientID) {
        for (User user : users) {
            if (user.getId() == clientID) {
                return Optional.of(user);
            }
        }
        System.out.println("No client with such ID");
        return Optional.empty();
    }

//    @Override
//    public List<Order> getAllOrders() {
//        return orders;
//    }
//
//    @Override
//    public List<Order> searchOrderByClientIDAndDate(Long clientID, Date orderDate) {
//        return orders.stream()
//                .filter(order -> order.getClientID().equals(clientID))
//                .filter(order -> order.getClientID().equals(orderDate))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Order> searchOrdersByClientID(Long clientID) {
//        return orders.stream()
//                .filter(order -> order.getClientID().equals(clientID))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Order> searchOrderByDate(Date orderDate) {
//        return orders.stream()
//                .filter(order -> order.getClientID().equals(orderDate))
//                .collect(Collectors.toList());
//    }

}



