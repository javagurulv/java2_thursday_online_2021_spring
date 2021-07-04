package lv.javaguru.java2.wasterestarant.core.database.product;

import lv.javaguru.java2.wasterestarant.core.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setName(rs.getString("name"));
        product.setQuantity(rs.getDouble("quantity"));
        product.setPrice(rs.getLong("price"));
        product.setExpiryDate(rs.getDate("expiryDate"));
        return product;
    }
}
