package lv.javaguru.java2.wasterestarant.core.services.ingredient;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.ingredient.SearchIngredientRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import lv.javaguru.java2.wasterestarant.core.services.ingredient.validators.SearchIngredientValidator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchIngredientValidatorTest {

    private SearchIngredientValidator validator = new SearchIngredientValidator();

    @Test
    public void shouldNotReturnErrorsWhenTitleIsProvided() {
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient");
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchIngredientRequest request = new SearchIngredientRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Ingredient Name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionIsEmpty() {
        Ordering ordering = new Ordering("Q", null);
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenOrderByIsEmpty() {
        Ordering ordering = new Ordering(null, "A");
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenOrderByContainsInvalidValue() {
        Ordering ordering = new Ordering("notValidValue", "A");
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must contain 'N' or 'Q' only");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionContainsInvalidValue() {
        Ordering ordering = new Ordering("Q", "notValidValue");
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must contain 'A' or 'D' only");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberContainsInvalidValue() {
        Paging paging = new Paging(0, 1);
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must be greater than 0");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeContainsInvalidValue() {
        Paging paging = new Paging(1, 0);
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must be greater than 0");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberIsEmpty() {
        Paging paging = new Paging(null, 1);
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeAreEmpty() {
        Paging paging = new Paging(1, null);
        SearchIngredientRequest request = new SearchIngredientRequest("Ingredient", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }
}
