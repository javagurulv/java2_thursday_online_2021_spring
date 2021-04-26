package matchers;

import lv.javaguru.java2.wasterestarant.domain.Product;
import org.mockito.ArgumentMatcher;

// AndrejsB
public class ProductMatcher implements ArgumentMatcher<Product> {
    private String name;

    public ProductMatcher(String name) {
        this.name = name;
    }

    @Override
    public boolean matches(Product product) {
        return product.getName().equals(name);
    }
}
