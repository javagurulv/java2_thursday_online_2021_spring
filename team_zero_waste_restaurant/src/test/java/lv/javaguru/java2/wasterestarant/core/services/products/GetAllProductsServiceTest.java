package lv.javaguru.java2.wasterestarant.core.services.products;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetRestaurantMenuRequest;
import lv.javaguru.java2.wasterestarant.core.requests.product.GetAllProductsRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.core.responses.product.GetAllProductsResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import lv.javaguru.java2.wasterestarant.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

//Elena
@RunWith(MockitoJUnitRunner.class)
public class GetAllProductsServiceTest {
    @Mock
    private Database database;
    @InjectMocks
    GetAllProductsService service;

    @Test
    public void shouldReturnAllProducts() throws ParseException {
        GetAllProductsRequest request = new GetAllProductsRequest();
        Product onion1 = new Product("onion", 2.0, 0.5, new SimpleDateFormat("dd/MM/yyyy")
                .parse("12/05/2021"));
        Product onion2 = new Product("onion", 3.0, 0.6, new SimpleDateFormat("dd/MM/yyyy")
                .parse("10/05/2021"));
        Mockito.when(database.getAllProducts())
                .thenReturn(List.of(onion1, onion2));
        GetAllProductsResponse response = service.execute(request);
        assertEquals(response.getProducts().size(), 2);
    }
}