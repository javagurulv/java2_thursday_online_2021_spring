package lv.javaguru.java2.realestate.core.services;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;

import java.util.ArrayList;
import java.util.List;

import lv.javaguru.java2.realestate.matchers.OfferMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;
import lv.javaguru.java2.realestate.core.services.validators.CreateOfferValidator;

@RunWith(MockitoJUnitRunner.class)
public class CreateOfferServiceTest {

    @Mock
    private Database database;
    @Mock
    private CreateOfferValidator validator;
    @InjectMocks
    private CreateOfferService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenOfferTypeIsEmpty() {
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
    public void shouldReturnResponseWithErrorsWhenPropertyCategoryIsEmpty(){
        CreateOfferRequest request = new CreateOfferRequest(
                "Offer Type",null,"Description", 20.0);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Property Category", "Must not be empty"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        CreateOfferResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(),1);
        assertEquals(response.getErrors().get(0).getField(),"Property Category");
        assertEquals(response.getErrors().get(0).getMessage(),"Must not be empty");

        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenDescriptionIsEmpty(){
        CreateOfferRequest request = new CreateOfferRequest(
                "Offer Type","Property Category", null, 20.0);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Description", "Must not be empty"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        CreateOfferResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(),1);
        assertEquals(response.getErrors().get(0).getField(),"Description");
        assertEquals(response.getErrors().get(0).getMessage(),"Must not be empty");

        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldReturnResponseWithErrorsWhenPriceIsEmpty(){
        CreateOfferRequest request = new CreateOfferRequest(
                "Offer Type","Property Category","Description",0.0);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Price", "Must not be zero"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        CreateOfferResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(),"Price");
        assertEquals(response.getErrors().get(0).getMessage(),"Must not be zero");

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
