package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.core.domain.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Database {

    void save(Dish dish);

    void save(Product product);

    void save(Client client);

    void save(Ingredient ingredient);

    void save(Order order);

    boolean deleteDishByName(String name);

    boolean deleteProductByName(String name);

    boolean deleteDishByID(Long dishID);

    List<Ingredient> findIngredientByName(String name);

    List<Dish> getAllDishes();

    List<Dish> findDishByName(String name);

    List<Dish> findDishByType(String type);

    List<Dish> findDishByPrice(Double price);

    List<Dish> findDishByNameAndType(String name, String type);

    List<Dish> findDishByNameAndPrice(String name, Double price);

    List<Dish> findDishByTypeAndPrice(String type, Double price);

    List<Dish> findDishByNameAndTypeAndPrice(String name, String type, Double price);

    List<Product> getAllProducts();

    List<Dish> getRestaurantMenu();

    List<Product> searchProductByName(String name);

    Optional<Client> clientByID (Long clientID);

    List<OrderItem> getWishlistByClientID(Long clientID);

    OrderItem selectedOrderItem(String dishName, int quantity);

    void addDishToWishlist(Long clientID, String dishName, int quantity);

    List<Order> getAllOrders();

    List<Order> getOrdersByClientID(Long clientID);

    List<Order> getOrderByDate(Date orderDate);

}
