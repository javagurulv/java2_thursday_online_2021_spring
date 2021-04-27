package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryDatabaseImpl implements Database {
    private Long nextId = 1L;
    private List<Dish> dishes = new ArrayList<>();
    private List<Dish> restaurantMenu = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

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
    public void save(Ingredient ingredient) {
        ingredients.add(ingredient);

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
    public List<Ingredient> findIngredientByName(String name) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getIngredient().equals(name))
                .collect(Collectors.toList());
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
    public List<Product> searchProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Client> clientByID(Long clientID) {
        for (Client client : clients) {
            if (client.getClientID() == clientID) {
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<OrderItem> getWishlistByClientID(Long clientID) {
        return clientByID(clientID).get().getCart().getClientsWishlist();
    }

    @Override
    public OrderItem selectedOrderItem(String dishName, int quantity) {
        return new OrderItem(dishName, quantity);
    }

    @Override
    public void addDishToWishlist(Long clientID, String dishName, int quantity) {
        getWishlistByClientID(clientID).add(selectedOrderItem(dishName, quantity));
    }

    @Override
    public void save(Order order) {
        order.setOrderID(nextId);
        nextId++;
        orders.add(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }

    @Override
    public List<Order> getOrdersByClientID(Long clientID) {
        return orders.stream()
                .filter(ingredient -> ingredient.getClientID().equals(clientID))
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrderByDate(Date orderDate) {
        return orders.stream()
                .filter(ingredient -> ingredient.getClientID().equals(orderDate))
                .collect(Collectors.toList());
    }

}



