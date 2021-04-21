package lv.javaguru.java2.wasterestarant.core.services;

import lv.javaguru.java2.wasterestarant.core.database.Database;
import lv.javaguru.java2.wasterestarant.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.SearchDishesResponse;
import lv.javaguru.java2.wasterestarant.domain.Dish;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchDishesServiceTest {
    private Database database = new InMemoryDatabaseImpl();
    private SearchDishesRequestValidator validator = new SearchDishesRequestValidator();
    SearchDishesService searchDishesService = new SearchDishesService(database, validator);

    @Before
    public void setUp() {
        Dish pizzaMargherita = new Dish("Pizza Margherita", "Margarita", "Pizza", 0.2, 4.99);
        Dish pizzaPepperoni = new Dish("Pizza Pepperoni", "Margarita", "Pizza", 0.2, 5.99);
        Dish pizzaMarinara = new Dish("Pizza Marinara", "Margarita", "Pizza", 0.2, 6.99);
        Dish soupPumpkin = new Dish("Pumpkin soup", "soup", "Soup", 0.2, 2.99);
        Dish soupTomato = new Dish("Tomato soup", "soup", "Soup", 0.2, 3.99);
        database.save(pizzaPepperoni);
        database.save(pizzaMarinara);
        database.save(pizzaMargherita);
        database.save(soupPumpkin);
        database.save(soupTomato);
    }
    @Test
    public void searchWithoutOrdering() {
        SearchDishesRequest request = new SearchDishesRequest("", "Pizza", 4.99);
        SearchDishesResponse actualResponse = searchDishesService.execute(request);
        assertEquals(3, actualResponse.getDishes().size());
    }

    @Test
    public void searchByTypeAscending() {
        Ordering ordering = new Ordering("type", "ASCENDING");
        SearchDishesRequest request = new SearchDishesRequest("", "Pizza", 4.99, ordering);
        SearchDishesResponse actualResponse = searchDishesService.execute(request);
        assertEquals(3, actualResponse.getDishes().size());
    }

    @Test
    public void searchByTypeDescending() {
        Ordering ordering = new Ordering("type", "DESCENDING");
        SearchDishesRequest request = new SearchDishesRequest("", "Pizza", 4.99, ordering);
        SearchDishesResponse actualResponse = searchDishesService.execute(request);
        assertEquals(3, actualResponse.getDishes().size());
    }

    @Test
    public void searchByNameDescending() {
        Ordering ordering = new Ordering("name", "DESCENDING");
        SearchDishesRequest request = new SearchDishesRequest("Pizza Margherita", "Pizza", 4.99, ordering);
        SearchDishesResponse actualResponse = searchDishesService.execute(request);
        assertEquals(1, actualResponse.getDishes().size());
    }

    @Test
    public void searchByPriceAscending() {
        Ordering ordering = new Ordering("price", "ASCENDING");
        SearchDishesRequest request = new SearchDishesRequest("", "Pizza", 4.99, ordering);
        SearchDishesResponse actualResponse = searchDishesService.execute(request);
        assertEquals(3, actualResponse.getDishes().size());
        assertEquals(actualResponse.getDishes().get(0).getPrice(), 4.99, 0);
    }

    @Test
    public void searchByPriceDescending() {
        Ordering ordering = new Ordering("price", "DESCENDING");
        SearchDishesRequest request = new SearchDishesRequest("", "Pizza", 4.99, ordering);
        SearchDishesResponse actualResponse = searchDishesService.execute(request);
        assertEquals(3, actualResponse.getDishes().size());
        assertEquals(actualResponse.getDishes().get(0).getPrice(), 6.99, 0);
    }
}