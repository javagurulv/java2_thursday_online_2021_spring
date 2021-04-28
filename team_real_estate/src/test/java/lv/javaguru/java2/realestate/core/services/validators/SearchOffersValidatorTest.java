package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.Ordering;
import lv.javaguru.java2.realestate.core.requests.Paging;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchOffersValidatorTest {

    private final SearchOffersValidator validator = new SearchOffersValidator();

    @Test
    public void shouldReturnErrorsWhenAllOfferFieldsAreNull() {
        SearchOffersRequest request = new SearchOffersRequest(null, null, 0.0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 3);

        assertEquals(errors.get(0).getField(), "Offer Type");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");

        assertEquals(errors.get(1).getField(), "Offer Category");
        assertEquals(errors.get(1).getMessage(), "Must not be empty!");

        assertEquals(errors.get(2).getField(), "Price");
        assertEquals(errors.get(2).getMessage(), "Must not be empty or zero!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderByIsIncorrect() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Ordering("unaccepted input", "ASCENDING"));
        List<CoreError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must contain |type|category|price only!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderDirectionIsIncorrect() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Ordering("type", "unaccepted input"));
        List<CoreError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must contain 'ASCENDING' or 'DESCENDING' only!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderByIsNull() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Ordering(null, "ASCENDING"));
        List<CoreError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderBy");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenOrderDirectionIsNull() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Ordering("type", null));
        List<CoreError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "orderDirection");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPageNumberIsIncorrect() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Paging(0, 1));
        List<CoreError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorsWhenPageSizeIsIncorrect() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Paging(1, 0));
        List<CoreError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must be greater then 0!");
    }

    @Test
    public void shouldReturnErrorsWhenPageNumberIsNull() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Paging(null, 1));
        List<CoreError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageNumber");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldReturnErrorsWhenPageSizeIsNull() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Paging(1, null));
        List<CoreError> errors = validator.validate(request);

        assertFalse(errors.isEmpty());
        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "pageSize");
        assertEquals(errors.get(0).getMessage(), "Must not be empty!");
    }

    @Test
    public void shouldSuccess() {
        SearchOffersRequest request = new SearchOffersRequest
                ("Offer Type", null, 0.0,
                        new Ordering("type", "ASCENDING"),
                        new Paging(1, 1));
        List<CoreError> errors = validator.validate(request);

        assertTrue(errors.isEmpty());
    }
}