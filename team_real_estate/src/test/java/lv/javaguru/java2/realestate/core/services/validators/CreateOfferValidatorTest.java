package lv.javaguru.java2.realestate.core.services.validators;

import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreateOfferValidatorTest {

    private final CreateOfferValidator validator = new CreateOfferValidator();

    @Test
    public void shouldReturnErrorWhenOfferTypeIsNull() {
        CreateOfferRequest request = new CreateOfferRequest(
                null, "Offer Category", "Description", 20.0);
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Offer Type");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorWhenPropertyCategoryIsNull() {
        CreateOfferRequest request = new CreateOfferRequest(
                "Offer Type", null, "Description", 20.0);
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Offer Category");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorsWhenDescriptionIsNull() {
        CreateOfferRequest request = new CreateOfferRequest(
                "Offer Type", "Offer Category", null, 20.0);
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Description");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");
    }

    @Test
    public void shouldReturnErrorsWhenPriceIsNull() {
        CreateOfferRequest request = new CreateOfferRequest(
                "Offer Type", "Offer Category", "Description", 0.0);
        List<CoreError> errors = validator.validate(request);

        assertEquals(errors.size(), 1);
        assertEquals(errors.get(0).getField(), "Price");
        assertEquals(errors.get(0).getMessage(), "Must not be zero");
    }

    @Test
    public void shouldReturnErrorsWhenAllFieldsAreNull() {
        CreateOfferRequest request = new CreateOfferRequest(null, null, null, 0.0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 4);

        assertEquals(errors.get(0).getField(), "Offer Type");
        assertEquals(errors.get(0).getMessage(), "Must not be empty");

        assertEquals(errors.get(1).getField(), "Offer Category");
        assertEquals(errors.get(1).getMessage(), "Must not be empty");

        assertEquals(errors.get(2).getField(), "Description");
        assertEquals(errors.get(2).getMessage(), "Must not be empty");

        assertEquals(errors.get(3).getField(), "Price");
        assertEquals(errors.get(3).getMessage(), "Must not be zero");
    }

    @Test
    public void shouldSuccess() {
        CreateOfferRequest request = new CreateOfferRequest(
                "Type", "Category", "Description", 20.0);
        List<CoreError> errors = validator.validate(request);
        assertEquals(errors.size(), 0);
    }

}
