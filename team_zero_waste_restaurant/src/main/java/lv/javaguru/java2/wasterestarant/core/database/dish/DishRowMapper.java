package lv.javaguru.java2.wasterestarant.core.database.dish;

import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//AndrejsB
public class DishRowMapper implements RowMapper<Dish> {
    @Override
    public Dish mapRow(ResultSet rs, int rowNum) throws SQLException {
        Dish dish = new Dish();
        dish.setDishID(rs.getLong("id"));
        dish.setName(rs.getString("name"));
        dish.setDescription(rs.getString("description"));
        dish.setType(rs.getString("type"));
        dish.setWeight(rs.getLong("weight"));
        dish.setPrice(rs.getLong("price"));
        return dish;
    }
}
