package lv.javaguru.java2.wasterestarant.core.database.product;

import lv.javaguru.java2.wasterestarant.core.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

//@Component
public class JdbcProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   @Override
    public void save(Product product) {
        jdbcTemplate.update(
                "INSERT INTO product(name, quantity, price, expiryDate)"
                        + "VALUES (?, ?, ?, ?)",
                product.getName(), product.getQuantity(), product.getPrice(), product.getExpiryDate()
        );
    }

    @Override
    public boolean deleteProductByName(String name) {
        String sql = "DELETE FROM product WHERE name = ?";
        Object[] args = new Object[]{name};
        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    @Override
    public List<Product> searchProductByName(String name) {
        String sql = "SELECT * FROM product WHERE name = ?";
        Object[] args = new Object[] {name};
        return jdbcTemplate.query(sql, args, new ProductRowMapper());
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return Optional.empty();
    }
}
