package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.dish.DishRepository;
import lv.javaguru.java2.wasterestarant.core.requests.GetRestaurantMenuRequest;
import lv.javaguru.java2.wasterestarant.core.responses.GetRestaurantMenuResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import lv.javaguru.java2.wasterestarant.core.GetRestaurantMenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GetRestaurantMenuServiceTest {
    @Mock
    DishRepository repository;
    @InjectMocks
    GetRestaurantMenuService service;

    @Test
    public void shouldReturnAllDishes() {
        GetRestaurantMenuRequest request = new GetRestaurantMenuRequest(true);
        Dish dish1 = new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99, true);
        Dish dish2 = new Dish("Marinara", "Marinara", "Pizza", 0.2, 6.99, true);
        Mockito.when(repository.getAllDishesInActiveMenu(true))
                .thenReturn(List.of(dish1, dish2));
        GetRestaurantMenuResponse response = service.execute(request);
        assertEquals(response.getRestaurantMenu().size(), 2);
    }
}