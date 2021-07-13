package lv.javaguru.java2.wasterestarant.core.database.dish;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;
import java.util.Optional;

//AndrejsB
//@Component
public class JdbcDishRepository implements DishRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Dish dish) {
        jdbcTemplate.update(
                "INSERT INTO dish(name, description, type , weight, price)"
                        + "VALUES (?, ?, ?, ?, ?)",
                dish.getName(), dish.getDescription(), dish.getType(), dish.getWeight(), dish.getPrice()
        );
    }

    @Override
    public boolean deleteDishByName(String name) {
        String sql = "DELETE FROM dish WHERE name = ?";
        Object[] args = new Object[]{name};
        return jdbcTemplate.update(sql, args) == 1;
    }
    @Override
    public List<Dish> getAllDishes() {
        String sql = "SELECT * FROM dish";
        return jdbcTemplate.query(sql, new DishRowMapper());
    }

    @Override
    public List<Dish> getAllDishesInActiveMenu(boolean isInActiveMenu) {
        return null;
    }

    @Override
    public Optional<Dish> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Dish> findDishByName(String name) {
        String sql = "SELECT * FROM dish WHERE name = ?";
        Object[] args = new Object[] {name};
        return jdbcTemplate.query(sql, args, new DishRowMapper());
    }

    @Override
    public List<Dish> findDishByType(String type) {
        String sql = "SELECT * FROM dish WHERE type = ?";
        Object[] args = new Object[] {type};
        return jdbcTemplate.query(sql, args, new DishRowMapper());
    }

    @Override
    public List<Dish> findDishByPrice(Double price) {
        String sql = "SELECT * FROM dish WHERE price = ?";
        Object[] args = new Object[] {price};
        return jdbcTemplate.query(sql, args, new DishRowMapper());
    }

    @Override
    public List<Dish> findDishByNameAndType(String name, String type) {
        String sql = "SELECT * FROM dish WHERE name = ? AND type = ?";
        Object[] args = new Object[] {name, type};
        return jdbcTemplate.query(sql, args, new DishRowMapper());
    }

    @Override
    public List<Dish> findDishByNameAndPrice(String name, Double price) {
        String sql = "SELECT * FROM dish WHERE name = ? AND price = ?";
        Object[] args = new Object[] {name, price};
        return jdbcTemplate.query(sql, args, new DishRowMapper());
    }

    @Override
    public List<Dish> findDishByTypeAndPrice(String type, Double price) {
        String sql = "SELECT * FROM dish WHERE type = ? AND price = ?";
        Object[] args = new Object[] {type, price};
        return jdbcTemplate.query(sql, args, new DishRowMapper());
    }

    @Override
    public List<Dish> findDishByNameAndTypeAndPrice(String name, String type, Double price) {
        String sql = "SELECT * FROM dish WHERE name = ? AND type = ? AND price = ?";
        Object[] args = new Object[] {name, type, price};
        return jdbcTemplate.query(sql, args, new DishRowMapper());
    }










}
