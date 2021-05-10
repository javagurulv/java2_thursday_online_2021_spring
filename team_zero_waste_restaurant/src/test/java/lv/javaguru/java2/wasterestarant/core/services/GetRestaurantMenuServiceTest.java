package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.requests.GetRestaurantMenuRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

//Elena
@RunWith(MockitoJUnitRunner.class)
public class GetRestaurantMenuServiceTest {
    @Mock
    private Database database;
    @InjectMocks
    GetRestaurantMenuService service;

    @Test
    public void shouldReturnAllDishesInMenu() {
        GetRestaurantMenuRequest request = new GetRestaurantMenuRequest();
        Dish dish1 = new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99);
        Dish dish2 = new Dish("Marinara", "Marinara", "Pizza", 0.2, 6.99);
        Mockito.when(database.getRestaurantMenu())
                .thenReturn(List.of(dish1, dish2));
        GetRestaurantMenuResponse response = service.execute(request);
        assertEquals(response.getRestaurantMenu().size(), 2);
    }
}