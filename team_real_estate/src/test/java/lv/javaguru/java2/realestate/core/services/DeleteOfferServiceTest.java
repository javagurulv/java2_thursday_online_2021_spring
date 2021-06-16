package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;
import lv.javaguru.java2.realestate.core.services.validators.DeleteOfferValidator;
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

@RunWith(MockitoJUnitRunner.class)
public class DeleteOfferServiceTest {

    @Mock
    private OfferRepository database;
    @Mock
    private DeleteOfferValidator validator;
    @InjectMocks
    private DeleteOfferService service;

    @Test
    public void shouldReturnErrorWhenWhenValidationFails() {
        DeleteOfferRequest request = new DeleteOfferRequest(null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("ID", "Must not be empty"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        DeleteOfferResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "ID");
        assertEquals(response.getErrors().get(0).getMessage(), "Must not be empty");

        Mockito.verifyNoInteractions(database);
    }

    @Test
    public void shouldDeleteOfferWithIdFromDatabase() {
        Mockito.when(validator.validate(any())).thenReturn(new ArrayList<>());
        Mockito.when(database.deleteOfferByID(1)).thenReturn(true);
        DeleteOfferRequest request = new DeleteOfferRequest(1);
        DeleteOfferResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertTrue(response.isOfferDeleted());


    }
}
