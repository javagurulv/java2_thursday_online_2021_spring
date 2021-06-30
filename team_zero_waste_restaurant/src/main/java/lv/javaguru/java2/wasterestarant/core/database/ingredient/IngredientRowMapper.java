package lv.javaguru.java2.wasterestarant.core.database.ingredient;


import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
//AndrejsB
public class IngredientRowMapper implements RowMapper<Ingredient> {
    @Override
    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(rs.getString("name"));
        ingredient.setQuantity(rs.getDouble("quantity"));
        return null;
    }
}
