package lv.javaguru.java2.wasterestarant.core.database.ingredient;

import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
//AndrejsB
@Component
public class JdbcIngredientDatabase implements IngredientDatabase{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Ingredient ingredient) {

        jdbcTemplate.update(
                "INSERT INTO ingredient(name, quantity)"
                        + "VALUES(?, ?)",
               ingredient.getIngredient(), ingredient.getQuantity()
        );
    }
    @Override
    public List<Ingredient> findIngredientByName(String name) {
        String sql = "SELECT * FROM ingredient WHERE name = ?";
        Object[] args = new Object[] {name};
        return jdbcTemplate.query(sql, args, new IngredientRowMapper());
    }
}
