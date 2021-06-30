package lv.javaguru.java2.wasterestarant.core.services.ingredient;


import lv.javaguru.java2.wasterestarant.core.database.ingredient.IngredientRepository;
import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.responses.ingredient.SearchIngredientResponse;
import lv.javaguru.java2.wasterestarant.core.domain.Ingredient;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.validators.SearchIngredientValidator;
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

@RunWith(MockitoJUnitRunner.class)
public class SearchIngredientServiceTest {

    @Mock
    private IngredientRepository database;
    @Mock
    private SearchIngredientValidator validator;
    @InjectMocks
    private SearchIngredientService service;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(service, "orderingEnabled", true);
        ReflectionTestUtils.setField(service, "pagingEnabled", true);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchIngredientRequest request = new SearchIngredientRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("ingredient", "Must not be empty!"));;
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchIngredientResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldSearchByIngredientName() {
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Ingredient",null));
        Mockito.when(database.findIngredientByName("Ingredient")).thenReturn(ingredients);

        SearchIngredientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getName(), "Ingredient");
    }

    @Test
    public void shouldSearchByTitleWithOrderingAscending() {
        Ordering ordering = new Ordering("Q", "A");
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Ingredient", 0.70));
        ingredients.add(new Ingredient("Ingredient", 0.60));
        Mockito.when(database.findIngredientByName("Ingredient")).thenReturn(ingredients);

        SearchIngredientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 2);
        assertEquals(response.getIngredients().get(0).getQuantity(), 0.60, 0.001);
        assertEquals(response.getIngredients().get(1).getQuantity(), 0.70, 0.001);
    }

    @Test
    public void shouldSearchByTitleWithOrderingDescending() {
        Ordering ordering = new Ordering("Q", "D");
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", ordering);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Ingredient", 0.70));
        ingredients.add(new Ingredient("Ingredient", 0.60));
        ingredients.add(new Ingredient("Ingredient", 0.50));
        Mockito.when(database.findIngredientByName("Ingredient")).thenReturn(ingredients);

        SearchIngredientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 3);
        assertEquals(response.getIngredients().get(0).getQuantity(), 0.70, 0.001);
        assertEquals(response.getIngredients().get(1).getQuantity(), 0.60, 0.001);
        assertEquals(response.getIngredients().get(2).getQuantity(), 0.50, 0.001);
    }

    @Test
    public void shouldSearchByTitleWithPagingFirstPage() {
        Paging paging = new Paging(1, 1);
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> books = new ArrayList<>();
        books.add(new Ingredient("Ingredient", 0.6));
        books.add(new Ingredient("Ingredient", 0.7));
        Mockito.when(database.findIngredientByName("Ingredient")).thenReturn(books);

        SearchIngredientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getName(), "Ingredient");
        assertEquals(response.getIngredients().get(0).getQuantity(), 0.6, 0.001);
    }

    @Test
    public void shouldSearchByTitleWithPagingSecondPage() {
        Paging paging = new Paging(2, 1);
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", null, paging);
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());

        List<Ingredient> books = new ArrayList<>();
        books.add(new Ingredient("Ingredient", 0.6));
        books.add(new Ingredient("Ingredient", 0.7));
        Mockito.when(database.findIngredientByName("Ingredient")).thenReturn(books);

        SearchIngredientResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getIngredients().size(), 1);
        assertEquals(response.getIngredients().get(0).getName(), "Ingredient");
        assertEquals(response.getIngredients().get(0).getQuantity(), 0.7, 0.001);
    }


}
