package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.Ordering;
import lv.javaguru.java2.realestate.core.requests.Paging;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.CoreError;
import lv.javaguru.java2.realestate.core.response.SearchOffersResponse;
import lv.javaguru.java2.realestate.core.services.validators.SearchOffersValidator;
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

@RunWith(MockitoJUnitRunner.class)
public class SearchOffersServiceTest {

    @Before
    public void setup(){
        ReflectionTestUtils.setField(service,"orderingEnabled",true);
        ReflectionTestUtils.setField(service,"pagingEnabled",true);
    }

    @Mock
    private OfferRepository database;
    @Mock
    private SearchOffersValidator validator;
    @InjectMocks
    private SearchOffersService service;

    @Test
    public void shouldReturnResponseWithErrors() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Ordering("Unaccepted input", "ASCENDING"),
                new Paging(1, 1));
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("orderBy", "Must contain |type|category|price only!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchOffersResponse response = service.execute(request);
        assertFalse(response.getErrors().isEmpty());
        assertTrue(response.hasErrors());

        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "orderBy");
        assertEquals(response.getErrors().get(0).getMessage(), "Must contain |type|category|price only!");
    }

    @Test
    public void shouldReturnResponseWithoutErrors() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Ordering("type", "ASCENDING"),
                new Paging(1, 1));
        List<CoreError> errors = new ArrayList<>();
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchOffersResponse response = service.execute(request);
        assertTrue(response.getErrors().isEmpty());
        assertFalse(response.hasErrors());
        assertEquals(response.getErrors().size(), 0);
    }

    @Test
    public void shouldReturnResponseWithOffers() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Ordering("type", "ASCENDING"),
                new Paging(1, 1));

        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer("Type", "Category", "Description", 20.0));
        Mockito.when(database.searchOffers(request)).thenReturn(offers);

        SearchOffersResponse response = service.execute(request);
        assertFalse(response.getFoundOffers().isEmpty());
        assertEquals(response.getFoundOffers().size(), 1);
        assertEquals(response.getFoundOffers().get(0), (new Offer
                ("Type", "Category", "Description", 20.0)));
    }

    @Test
    public void shouldReturnResponseWithoutOffers() {
        SearchOffersRequest request = new SearchOffersRequest("Offer Type", null, 0.0,
                new Ordering("type", "ASCENDING"),
                new Paging(1, 0));

        List<Offer> offers = new ArrayList<>();
        Mockito.when(database.searchOffers(request)).thenReturn(offers);

        SearchOffersResponse response = service.execute(request);
        assertTrue(response.getFoundOffers().isEmpty());
        assertEquals(response.getFoundOffers().size(), 0);
    }
}
