package lv.javaguru.java2.wasterestarant.core.database.product;

import lv.javaguru.java2.wasterestarant.core.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    boolean deleteProductByName(String name);

    List<Product> getAllProducts();

    List<Product> searchProductByName(String name);

    Optional<Product> getProductById(Long id);

}
