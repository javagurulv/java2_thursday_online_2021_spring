package lv.javaguru.java2.wasterestarant.core.services.products.validators;

import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
//AndrejsB
public class RemoveProductValidatorTest {

    private RemoveProductValidator validator = new RemoveProductValidator();

    @Test
    public void shouldReturnErrorWhenSearchedNameIsNull(){
        RemoveProductRequest request = new RemoveProductRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "nameToRemove");
        assertEquals(errors.get(0).getMessage(), "must not be empty");
    }

    @Test
    public void shouldRemoveProduct() {
        RemoveProductRequest request = new RemoveProductRequest("name");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }
}
