package lv.javaguru.java2.wasterestarant.core.services.wishlist;

import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

//Nataliya

public class AddDishToWishlistValidatorTest {

    private AddDishToWishlistValidator validator = new AddDishToWishlistValidator();

    @Test
    public void shouldReturnErrorWhenClientIDIsNull() {
        AddDishToWishlistRequest request = new AddDishToWishlistRequest(null, "Risotto with mushrooms",
                2);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "ClientID");
        assertEquals(errors.get(0).getMessage(), "Must not be null");
    }

    @Test
    public void shouldReturnErrorWhenDishNameIsNull() {
        AddDishToWishlistRequest request = new AddDishToWishlistRequest(13L, null,
                2);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "DishName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenDishNameIsEmpty () {
        AddDishToWishlistRequest request = new AddDishToWishlistRequest(13L, "",
                2);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "DishName");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenQuantityIsNull() {
        AddDishToWishlistRequest request = new AddDishToWishlistRequest(13L, "Risotto with mushrooms",
                0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Quantity");
        assertEquals(errors.get(0).getMessage(), "Must be a valid int value");
    }

    @Test
    public void shouldReturnErrorWhenQuantityIsNegative() {
        AddDishToWishlistRequest request = new AddDishToWishlistRequest(13L, "Risotto with mushrooms",
                -1);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Quantity");
        assertEquals(errors.get(0).getMessage(), "Must be a valid int value");
    }

    @Test
    public void shouldSuccessfullyAdd() {
        AddDishToWishlistRequest request = new AddDishToWishlistRequest(13L, "Risotto with mushrooms",
                2);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}