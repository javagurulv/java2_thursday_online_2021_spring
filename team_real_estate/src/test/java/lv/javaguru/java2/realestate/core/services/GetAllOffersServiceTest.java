package lv.javaguru.java2.realestate.core.services;

import lv.javaguru.java2.realestate.core.database.offer.OfferRepository;
import lv.javaguru.java2.realestate.core.domain.Offer;
import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetAllOffersServiceTest {
    @Mock
    private OfferRepository database;

    @InjectMocks
    private GetAllOffersService service;

    @Test
    public void shouldGetAllOffers() {
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer("Offer Type", "Offer Category", "Description", 20.0));
        Mockito.when(database.getAllOffers()).thenReturn(offers);

        GetAllOffersRequest request = new GetAllOffersRequest();
        GetAllOffersResponse response = service.execute(request);

        assertEquals(response.getOfferList().get(0).getOfferType(), "Offer Type");
        assertEquals(response.getOfferList().get(0).getOfferCategory(), "Offer Category");
        assertEquals(response.getOfferList().get(0).getDescription(), "Description");
        assertEquals(response.getOfferList().get(0).getPrice(), 20.0, 0.001);
    }
}
