package lv.javaguru.java2.wasterestarant.core.services.dish.validators;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.dish.SearchDishesRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchDishesRequestValidatorTest {

    SearchDishesRequestValidator validator = new SearchDishesRequestValidator();

    @Test
    public void shouldNotReturnErrorsWhenNameIsProvided() {
        SearchDishesRequest request = new SearchDishesRequest("Pizza", null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void shouldNotReturnErrorsWhenTypeIsProvided() {
        SearchDishesRequest request = new SearchDishesRequest("", "Pizza", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void shouldNotReturnErrorsWhenPriceIsProvided() {
        SearchDishesRequest request = new SearchDishesRequest("", "", 4.99);
        List<CoreError> errors = validator.validate(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void shouldNotReturnErrorsWhenNameAndTypeIsProvided() {
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void shouldNotReturnErrorsWhenNameAndPriceIsProvided() {
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "", 4.99);
        List<CoreError> errors = validator.validate(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void shouldNotReturnErrorsWhenTypeAndPriceIsProvided() {
        SearchDishesRequest request = new SearchDishesRequest("", "Pizza", 4.99);
        List<CoreError> errors = validator.validate(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void shouldReturnErrorWhenSearchFieldsAreEmpty() {
        SearchDishesRequest request = new SearchDishesRequest(null, null, null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "One of the fields");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionAreEmpty() {
        Ordering ordering = new Ordering("name", null);
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", 4.99, ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals( 1, errors.size());
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderByAreEmpty() {
        Ordering ordering = new Ordering(null, "ASCENDING");
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", 4.99, ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenOrderByContainNotValidValue() {
        Ordering ordering = new Ordering("notValidValue", "ASCENDING");
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", 4.99, ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must contain 'name' or 'type' or 'price' only!");
    }

    @Test
    public void shouldReturnErrorWhenOrderDirectionContainNotValidValue() {
        Ordering ordering = new Ordering("name", "notValidValue");
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", 4.99, ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must contain 'ASCENDING' or 'DESCENDING' only!");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberContainNotValidValue() {
        Paging paging = new Paging(0, 1);
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", 4.99, paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeContainNotValidValue() {
        Paging paging = new Paging(1, 0);
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", 4.99, paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorWhenPageNumberAreEmpty() {
        Paging paging = new Paging(null, 1);
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", 4.99, paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhenPageSizeAreEmpty() {
        Paging paging = new Paging(1, null);
        SearchDishesRequest request = new SearchDishesRequest("Pizza", "Pizza", 4.99, paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }
}