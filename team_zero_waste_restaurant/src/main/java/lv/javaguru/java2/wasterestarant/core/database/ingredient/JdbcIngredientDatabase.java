package lv.javaguru.java2.wasterestarant.core.database.ingredient;

import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;
import lv.javaguru.java2.wasterestarant.core.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
//AndrejsB IN PROGRESS......
public class JdbcIngredientDatabase implements IngredientDatabase{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Ingredient ingredient) {
        Product product = new Product();
        jdbcTemplate.update(
                "INSERT INTO ingredient(product_id, name, quantity)"
                        + "VALUES((SELECT id FROM product WHERE name = ?), ?, ?)",
                product.getProductID(), ingredient.getIngredient(), ingredient.getQuantity()
        );
    }
    @Override
    public List<Ingredient> findIngredientByName(String name) {
        String sql = "SELECT * FROM ingredient WHERE name = ?";
        Object[] args = new Object[] {name};
        return jdbcTemplate.query(sql, args, new IngredientRowMapper());
    }
}
