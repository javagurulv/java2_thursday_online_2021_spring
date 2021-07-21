package lv.javaguru.java2.wasterestarant.core.services.dish;

import lv.javaguru.java2.wasterestarant.core.database.dish.DishRepository;
import lv.javaguru.java2.wasterestarant.core.services.dish.validators.SearchDishesRequestValidator;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.dish.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.dish.SearchDishesResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Dish;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

//Elena
@RunWith(MockitoJUnitRunner.class)
public class SearchDishesServiceTest {
    @Mock
    private DishRepository database;
    @Mock
    private SearchDishesRequestValidator validator;
    @InjectMocks
    SearchDishesService searchDishesService;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(searchDishesService, "orderingEnabled", true);
        ReflectionTestUtils.setField(searchDishesService, "pagingEnabled", true);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchDishesRequest request = new SearchDishesRequest(null, null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("name", "Must not be empty!"));
        errors.add(new CoreError("type", "Must not be empty!"));
        errors.add(new CoreError("price", "Must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 3);
        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(database);
    }
    @Test
    public void shouldSearchByName() {
        SearchDishesRequest request = new SearchDishesRequest("Margherita", null, null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margarita", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByName("Margherita")).thenReturn(dishes);

        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 1);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
    }
    @Test
    public void shouldSearchByType() {
        SearchDishesRequest request = new SearchDishesRequest(null, "Pizza", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Marinara", "Marinara", "Pizza", 0.2, 6.99));
        Mockito.when(database.findDishByType("Pizza")).thenReturn(dishes);

        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getDescription(), "Margherita");
        assertEquals(response.getDishes().get(1).getName(), "Marinara");
        assertEquals(response.getDishes().get(1).getDescription(), "Marinara");
    }

    @Test
    public void shouldSearchByPrice() {
        SearchDishesRequest request = new SearchDishesRequest(null, null, 4.99);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Marinara", "Marinara", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByPrice(4.99)).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getDescription(), "Margherita");
        assertEquals(response.getDishes().get(1).getName(), "Marinara");
        assertEquals(response.getDishes().get(1).getDescription(), "Marinara");
    }

    @Test
    public void shouldSearchByNameAndType() {
        SearchDishesRequest request = new SearchDishesRequest("Margherita", "Pizza", null);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByNameAndType("Margherita", "Pizza")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 1);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
    }

    @Test
    public void shouldSearchByNameAndPrice() {
        SearchDishesRequest request = new SearchDishesRequest("Margherita", null, 4.99);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByNameAndPrice("Margherita", 4.99)).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 1);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
    }

    @Test
    public void shouldSearchByTypeAndPrice() {
        SearchDishesRequest request = new SearchDishesRequest(null, "Pizza", 4.99);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByTypeAndPrice("Pizza", 4.99)).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 1);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
    }

    @Test
    public void shouldSearchByNameAndTypeAndPrice() {
        SearchDishesRequest request = new SearchDishesRequest("Margherita", "Pizza", 4.99);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByNameAndTypeAndPrice("Margherita", "Pizza", 4.99)).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 1);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
    }

    @Test
    public void shouldSearchByTypeWithOrderingByNameAscending() {
        Ordering ordering = new Ordering("name", "ASCENDING");
        SearchDishesRequest request = new SearchDishesRequest(null, "Pizza", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Abc1", "Margherita", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Abc2", "Marinara", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByType("Pizza")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getName(), "Abc1");
        assertEquals(response.getDishes().get(1).getName(), "Abc2");
    }

    @Test
    public void shouldSearchByTypeWithOrderingByNameDescending() {
        Ordering ordering = new Ordering("name", "DESCENDING");
        SearchDishesRequest request = new SearchDishesRequest(null, "Pizza", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Abc1", "Margherita", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Abc2", "Marinara", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByType("Pizza")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getName(), "Abc2");
        assertEquals(response.getDishes().get(1).getName(), "Abc1");
    }

    @Test
    public void shouldSearchByNameWithOrderingByTypeAscending() {
        Ordering ordering = new Ordering("type", "ASCENDING");
        SearchDishesRequest request = new SearchDishesRequest("Marinara", null, null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Marinara", "Marinara", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Marinara", "Marinara", "Pasta", 0.2, 4.99));
        Mockito.when(database.findDishByName("Marinara")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getType(), "Pasta");
        assertEquals(response.getDishes().get(1).getType(), "Pizza");
    }

    @Test
    public void shouldSearchByNameWithOrderingByTypeDescending() {
        Ordering ordering = new Ordering("type", "DESCENDING");
        SearchDishesRequest request = new SearchDishesRequest("Marinara", null, null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Marinara", "Margherita", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Marinara", "Marinara", "Pasta", 0.2, 4.99));
        Mockito.when(database.findDishByName("Marinara")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
        assertEquals(response.getDishes().get(1).getType(), "Pasta");
    }

    @Test
    public void shouldSearchByTypeWithOrderingByPriceAscending() {
        Ordering ordering = new Ordering("price", "ASCENDING");
        SearchDishesRequest request = new SearchDishesRequest(null, "Pizza", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Marinara", "Marinara", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 5.99));
        Mockito.when(database.findDishByType("Pizza")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getPrice(), 4.99, 0);
        assertEquals(response.getDishes().get(1).getPrice(), 5.99, 0);
    }

    @Test
    public void shouldSearchByTypeWithOrderingByPriceDescending() {
        Ordering ordering = new Ordering("price", "DESCENDING");
        SearchDishesRequest request = new SearchDishesRequest(null, "Pizza", null, ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Marinara", "Marinara", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 5.99));
        Mockito.when(database.findDishByType("Pizza")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 2);
        assertEquals(response.getDishes().get(0).getPrice(), 5.99, 0);
        assertEquals(response.getDishes().get(1).getPrice(), 4.99, 0);
    }

    @Test
    public void shouldSearchByTitleWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchDishesRequest request = new SearchDishesRequest(null, "Pizza", null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Marinara", "Marinara", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByType("Pizza")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 1);
        assertEquals(response.getDishes().get(0).getName(), "Margherita");
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
        assertEquals(response.getDishes().get(0).getDescription(), "Margherita");
    }

    @Test
    public void shouldSearchByTitleWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchDishesRequest request = new SearchDishesRequest(null, "Pizza", null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        List<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("Margherita", "Margherita", "Pizza", 0.2, 4.99));
        dishes.add(new Dish("Marinara", "Marinara", "Pizza", 0.2, 4.99));
        Mockito.when(database.findDishByType("Pizza")).thenReturn(dishes);
        SearchDishesResponse response = searchDishesService.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getDishes().size(), 1);
        assertEquals(response.getDishes().get(0).getName(), "Marinara");
        assertEquals(response.getDishes().get(0).getType(), "Pizza");
        assertEquals(response.getDishes().get(0).getDescription(), "Marinara");
    }
}