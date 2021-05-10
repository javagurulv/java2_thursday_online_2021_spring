package lv.javaguru.java2.wasterestarant.core.services.wishlist;


import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.wishlist.AddDishToWishlistRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.wishlist.AddDishToWishlistResponse;
import lv.javaguru.java2.wasterestarant.core.domain.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

//Nataliya

@RunWith(MockitoJUnitRunner.class)

public class AddDishToWishlistServiceTest {

    @Mock
    private Database database;
    @Mock
    private AddDishToWishlistValidator validator;
    @InjectMocks
    private AddDishToWishlistService service;

    @Test
    public void shouldAddDishToWishlist() {

        AddDishToWishlistRequest request = new AddDishToWishlistRequest(13L, "Risotto with mushrooms",
                2);
        Mockito.when(validator.validate(request))
                .thenReturn(new ArrayList<>());
        AddDishToWishlistResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertNotNull(response.getNewSelectedItem());
        OrderItem newSelectedItem = response.getNewSelectedItem();
        Mockito.verify(database).addDishToWishlist(13L, "Risotto with mushrooms",
                2);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        AddDishToWishlistRequest request = new AddDishToWishlistRequest(13L,"Risotto with mushrooms",
                -1);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Quantity", "Must be a valid int value"));
        Mockito.when(validator.validate(request))
                .thenReturn(errors);

        AddDishToWishlistResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(errors.get(0).getField(), "Quantity");
        assertEquals(errors.get(0).getMessage(), "Must be a valid int value");

        Mockito.verifyNoInteractions(database);
    }


}