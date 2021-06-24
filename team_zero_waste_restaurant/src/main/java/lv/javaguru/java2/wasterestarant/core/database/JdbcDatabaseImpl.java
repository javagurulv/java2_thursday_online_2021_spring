package lv.javaguru.java2.wasterestarant.core.database;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import lv.javaguru.java2.wasterestarant.core.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
class JdbcDatabaseImpl implements Database {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Override
//    public void save(Dish dish) {
//        jdbcTemplate.update(
//                "INSERT INTO dish(name, description, type, weight, price)"
//                        + "VALUES (?, ?, ?, ?, ?)",
//                dish.getName(), dish.getDescription(), dish.getType(), dish.getWeight(), dish.getPrice()
//        );
//    }

    /*@Override
    public void save(Product product) {
        jdbcTemplate.update(
                "INSERT INTO product(name, quantity, price, expiryDate)"
                        + "VALUES (?, ?, ?, ?)",
                product.getName(), product.getQuantity(), product.getPrice(), product.getExpiryDate()
        );
    }*/

    @Override
    public void save(User user) {
        jdbcTemplate.update(
                "INSERT INTO client_list(name)"
                        + "VALUES (?)",
                user.getName()
        );
    }

//    @Override
//    public void save(Ingredient ingredient) {
//        Product product = new Product();
//        jdbcTemplate.update(
//                "INSERT INTO ingredient(product_id, name, quantity)"
//                        + "VALUES((SELECT id FROM product WHERE name = ?), ?, ?)",
//                product.getProductID(), ingredient.getIngredient(), ingredient.getQuantity()
//        );
//    }

//    @Override
//    public void save(Order order) {
//
//    }

//    @Override
//    public boolean deleteDishByName(String name) {
//        String sql = "DELETE FROM dish WHERE name = ?";
//        Object[] args = new Object[]{name};
//        return jdbcTemplate.update(sql, args) == 1;
//    }

   /* @Override
    public boolean deleteProductByName(String name) {
        String sql = "DELETE FROM product WHERE name = ?";
        Object[] args = new Object[]{name};
        return jdbcTemplate.update(sql, args) == 1;
    }*/

//    @Override
//    public boolean deleteDishByID(Long dishID) {
////        String sql = "DELETE FROM dish WHERE id = ?"; // No such function in program menu. Only delete by name
////        Object[] args = new Object[] {dishID};
////        return jdbcTemplate.update(sql, args) == 1;
//        return false;
//    }
//
//    @Override
//    public List<Ingredient> findIngredientByName(String name) {
//        String sql = "SELECT * FROM ingredient WHERE name = ?";
//        Object[] args = new Object[] {name};
//        return jdbcTemplate.query(sql, args, new IngredientRowMapper());
//    }
//
//    @Override
//    public List<Dish> getAllDishes() {
//        String sql = "SELECT * FROM dish";
//        return jdbcTemplate.query(sql, new DishRowMapper());
//    }
//
//    @Override
//    public List<Dish> findDishByName(String name) {
//        return null;
//    }
//
//    @Override
//    public List<Dish> findDishByType(String type) {
//        return null;
//    }
//
//    @Override
//    public List<Dish> findDishByPrice(Double price) {
//        return null;
//    }
//
//    @Override
//    public List<Dish> findDishByNameAndType(String name, String type) {
//        return null;
//    }
//
//    @Override
//    public List<Dish> findDishByNameAndPrice(String name, Double price) {
//        return null;
//    }
//
//    @Override
//    public List<Dish> findDishByTypeAndPrice(String type, Double price) {
//        return null;
//    }
//
//    @Override
//    public List<Dish> findDishByNameAndTypeAndPrice(String name, String type, Double price) {
//        return null;
//    }

    /*@Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }*/

    @Override
    public List<Dish> getRestaurantMenu() {
        return null;
    }

    /*@Override
    public List<Product> searchProductByName(String name) {
        String sql = "SELECT * FROM product WHERE name = ?";
        Object[] args = new Object[] {name};
        return jdbcTemplate.query(sql, args, new ProductRowMapper());
    }*/

    @Override
    public Optional<User> clientByID(Long clientID) {
        return Optional.empty();
    }
//
//    @Override
//    public List<Order> getAllOrders() {
//        return null;
//    }
//
//    @Override
//    public List<Order> searchOrdersByClientID(Long clientID) {
//        return null;
//    }
//
//    @Override
//    public List<Order> searchOrderByDate(Date orderDate) {
//        return null;
//    }
//
//    @Override
//    public List<Order> searchOrderByClientIDAndDate(Long clientID, Date orderDate) {
//        return null;
//    }
}
