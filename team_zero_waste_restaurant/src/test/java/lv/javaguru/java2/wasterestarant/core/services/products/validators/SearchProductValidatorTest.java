package lv.javaguru.java2.wasterestarant.core.services.products.validators;

import lv.javaguru.java2.wasterestarant.core.requests.Ordering;
import lv.javaguru.java2.wasterestarant.core.requests.Paging;
import lv.javaguru.java2.wasterestarant.core.requests.product.SearchProductRequest;
import lv.javaguru.java2.wasterestarant.core.responses.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchProductValidatorTest {

    SearchProductValidator validator = new SearchProductValidator();

    @Test
    public void shouldNotReturnErrorWhileSearchingWithName(){
        SearchProductRequest request = new SearchProductRequest("Onion");
        List<CoreError> errors = validator.validate(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void shouldReturnErrorWhileSearchingWithoutName(){
        SearchProductRequest request = new SearchProductRequest(null);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "name");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhileOrderDirectionIsEmpty(){
        Ordering ordering = new Ordering("BBD", null);
        SearchProductRequest request = new SearchProductRequest("Onion", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "ordering direction");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhileOrderByIsEmpty(){
        Ordering ordering = new Ordering(null, "ASC");
        SearchProductRequest request = new SearchProductRequest("Onion", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "ordering By");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldNotReturnErrorWhileOrderByAndOrderDirectionAreEmpty(){
        Ordering ordering = new Ordering(null, null);
        SearchProductRequest request = new SearchProductRequest("Onion", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(0, errors.size());
    }

    @Test
    public void shouldReturnErrorWhileOrderByContainNotValidValue() {
        Ordering ordering = new Ordering("notValidValue", "ASC");
        SearchProductRequest request = new SearchProductRequest("Onion", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "ordering By");
        assertEquals(errors.get(0).getMessage(),"Must contain only 'BBD' or 'Q'!");
    }

    @Test
    public void shouldReturnErrorWhileOrderDirectionContainNotValidValue() {
        Ordering ordering = new Ordering("BBD", "notValidValue");
        SearchProductRequest request = new SearchProductRequest("Onion", ordering);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "ordering direction");
        assertEquals(errors.get(0).getMessage(),"Must contain only 'ASC' or 'DESC'!");
    }

    @Test
    public void shouldReturnErrorWhilePageSizeContainNotValidValue() {
        Paging paging = new Paging(1, 0);
        SearchProductRequest request = new SearchProductRequest("Onion", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "Page size");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }
    @Test
    public void shouldReturnErrorWhilePageNumberContainNotValidValue() {
        Paging paging = new Paging(0, 1);
        SearchProductRequest request = new SearchProductRequest("Onion", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "Page number");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorWhilePageNumberIsEmpty() {
        Paging paging = new Paging(null, 1);
        SearchProductRequest request = new SearchProductRequest("Onion", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "Page number");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorWhilePageSizeIsEmpty() {
        Paging paging = new Paging(1, null);
        SearchProductRequest request = new SearchProductRequest("Onion", paging);
        List<CoreError> errors = validator.validate(request);
        assertEquals(1, errors.size());
        assertEquals(errors.get(0).getField(), "Page size");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

}