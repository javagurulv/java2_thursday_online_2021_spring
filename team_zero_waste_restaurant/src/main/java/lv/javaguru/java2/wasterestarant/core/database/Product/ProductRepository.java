package lv.javaguru.java2.wasterestarant.core.database.Product;

import lv.javaguru.java2.wasterestarant.core.domain.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);

    boolean deleteProductByName(String name);

    List<Product> getAllProducts();

    List<Product> searchProductByName(String name);

}
