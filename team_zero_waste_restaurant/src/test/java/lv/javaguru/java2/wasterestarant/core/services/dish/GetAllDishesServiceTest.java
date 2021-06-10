package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.dish.DishRepository;
import lv.javaguru.java2.wasterestarant.core.requests.dish.GetAllDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.dish.GetAllDishesResponse;
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
public class GetAllDishesServiceTest {
    @Mock
    private DishRepository database;
    @InjectMocks
    GetAllDishesService service;

    @Test
    public void shouldReturnAllDishes() {
        GetAllDishesRequest request = new GetAllDishesRequest();
        Dish dish1 = new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99);
        Dish dish2 = new Dish("Marinara", "Marinara", "Pizza", 0.2, 6.99);
        Mockito.when(database.getAllDishes())
                .thenReturn(List.of(dish1, dish2));
        GetAllDishesResponse response = service.execute(request);
        assertEquals(response.getDishes().size(), 2);
    }
}