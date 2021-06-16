package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;
import lv.javaguru.java2.realestate.core.services.validators.CreateOfferValidator;
import lv.javaguru.java2.realestate.matchers.OfferMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

@RunWith(MockitoJUnitRunner.class)
public class CreateOfferServiceTest {

    @Mock
    private OfferRepository database;
    @Mock
    private CreateOfferValidator validator;
    @InjectMocks
    private CreateOfferService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        CreateOfferRequest request = new CreateOfferRequest(
                null, "Category", "Description", 20.0);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("offerType", "Must not be empty"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        CreateOfferResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "offerType");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty");

        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldCreateOfferInDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        CreateOfferRequest request = new CreateOfferRequest(
                "Type", "Category", "Description", 20.0);
        CreateOfferResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        Mockito.verify(database).createOffer(
                argThat(new OfferMatcher(
                        "Type", "Category", "Description", 20.0)));


    }
}
