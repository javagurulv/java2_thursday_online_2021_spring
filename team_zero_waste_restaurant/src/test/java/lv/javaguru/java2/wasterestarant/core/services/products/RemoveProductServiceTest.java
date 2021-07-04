package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.product.ProductRepository;
import lv.javaguru.java2.wasterestarant.core.requests.product.RemoveProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.product.RemoveProductResponse;
import lv.javaguru.java2.wasterestarant.core.services.products.validators.RemoveProductValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

//AndrejsB
@RunWith(MockitoJUnitRunner.class)

public class RemoveProductServiceTest {

    @Mock
    private ProductRepository database;
    @Mock
    private RemoveProductValidator validator;
    @InjectMocks
    private RemoveProductService service;

    @Test
    public void shouldDeleteProductByName() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.when(database.deleteProductByName("name")).thenReturn(true);
        RemoveProductRequest request = new RemoveProductRequest("name");
        RemoveProductResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isProductRemoved());

    }

    @Test
    public void shouldReturnErrorWhenSearchIsNull() {
        RemoveProductRequest request = new RemoveProductRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("nameToRemove", "must not be empty"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        RemoveProductResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "nameToRemove");
        assertEquals(response.getErrors().get(0).getMessage(), "must not be empty");
    }
}
