package lv.javaguru.java2.realestate.acceptancetests;

import static org.junit.Assert.assertEquals;

import lv.javaguru.java2.realestate.config.RealEstateConfiguration;
import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.requests.Ordering;
import lv.javaguru.java2.realestate.core.requests.Paging;
import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.SearchOffersResponse;
import lv.javaguru.java2.realestate.core.services.CreateOfferService;
import lv.javaguru.java2.realestate.core.services.SearchOffersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AcceptanceTest2 {


    private ApplicationContext applicationContext;

    @Before
    public void setup(){
        applicationContext = new AnnotationConfigApplicationContext(RealEstateConfiguration.class);
    }

    @Test
    public void searchOffers() {
        CreateOfferRequest request1 =
                new CreateOfferRequest("Type", "Category1", "Description", 10.0);
        getCreateOfferService().execute(request1);

        CreateOfferRequest request2 =
                new CreateOfferRequest("Type", "Category2", "Description", 10.0);
        getCreateOfferService().execute(request2);

        SearchOffersRequest request3 =
                new SearchOffersRequest("Type", "", 10.0);
        SearchOffersResponse response = getSearchOffersService().execute(request3);

        assertEquals(response.getFoundOffers().size(), 2);
        assertEquals(response.getFoundOffers().get(0).getOfferType(), "Type");
        assertEquals(response.getFoundOffers().get(0).getOfferCategory(), "Category1");
        assertEquals(response.getFoundOffers().get(0).getPrice(), 10.0, 0.001);
        assertEquals(response.getFoundOffers().get(1).getOfferType(), "Type");
        assertEquals(response.getFoundOffers().get(1).getOfferCategory(), "Category2");
        assertEquals(response.getFoundOffers().get(1).getPrice(), 10.0, 0.001);
    }

    @Test
    public void searchOffersOrderingAscending() {
        CreateOfferRequest request1 =
                new CreateOfferRequest("Type", "Category1", "Description", 10.0);
        getCreateOfferService().execute(request1);

        CreateOfferRequest request2 =
                new CreateOfferRequest("Type", "Category2", "Description", 10.0);
        getCreateOfferService().execute(request2);

        Ordering ordering = new Ordering("type", "ASCENDING");
        SearchOffersRequest request3 =
                new SearchOffersRequest("Type", "", 10.0, ordering);
        SearchOffersResponse response = getSearchOffersService().execute(request3);

        assertEquals(response.getFoundOffers().size(), 2);
        assertEquals(response.getFoundOffers().get(0).getOfferType(), "Type");
        assertEquals(response.getFoundOffers().get(0).getOfferCategory(), "Category1");
        assertEquals(response.getFoundOffers().get(0).getPrice(), 10.0, 0.001);
        assertEquals(response.getFoundOffers().get(1).getOfferType(), "Type");
        assertEquals(response.getFoundOffers().get(1).getOfferCategory(), "Category2");
        assertEquals(response.getFoundOffers().get(1).getPrice(), 10.0, 0.001);
    }

    @Test
    public void searchOffersOrderingDescending() {
        CreateOfferRequest request1 =
                new CreateOfferRequest("Type", "Category1", "Description", 10.0);
        getCreateOfferService().execute(request1);

        CreateOfferRequest request2 =
                new CreateOfferRequest("Type", "Category2", "Description", 10.0);
        getCreateOfferService().execute(request2);

        Ordering ordering = new Ordering("type", "DESCENDING");
        SearchOffersRequest request3 =
                new SearchOffersRequest("Type", "", 10.0, ordering);
        SearchOffersResponse response = getSearchOffersService().execute(request3);

        assertEquals(response.getFoundOffers().size(), 2);
        assertEquals(response.getFoundOffers().get(0).getOfferType(), "Type");
        assertEquals(response.getFoundOffers().get(0).getOfferCategory(), "Category1");
        assertEquals(response.getFoundOffers().get(0).getPrice(), 10.0, 0.001);
        assertEquals(response.getFoundOffers().get(1).getOfferType(), "Type");
        assertEquals(response.getFoundOffers().get(1).getOfferCategory(), "Category2");
        assertEquals(response.getFoundOffers().get(1).getPrice(), 10.0, 0.001);
    }

    @Test
    public void searchOffersOrderingPaging() {
        CreateOfferRequest request1 =
                new CreateOfferRequest("Type", "Category1", "Description", 10.0);
        getCreateOfferService().execute(request1);

        CreateOfferRequest request2 =
                new CreateOfferRequest("Type", "Category2", "Description", 10.0);
        getCreateOfferService().execute(request2);

        Ordering ordering = new Ordering("type", "DESCENDING");
        Paging paging = new Paging(1, 1);
        SearchOffersRequest request3 =
                new SearchOffersRequest("Type", "", 10.0, ordering, paging);
        SearchOffersResponse response = getSearchOffersService().execute(request3);

        assertEquals(response.getFoundOffers().size(), 1);
        assertEquals(response.getFoundOffers().get(0).getOfferType(), "Type");
        assertEquals(response.getFoundOffers().get(0).getOfferCategory(), "Category1");
        assertEquals(response.getFoundOffers().get(0).getPrice(), 10.0, 0.001);
    }

    private CreateOfferService getCreateOfferService() { return applicationContext.getBean(CreateOfferService.class); }

    private SearchOffersService getSearchOffersService() { return applicationContext.getBean(SearchOffersService.class); }
}
