package lv.javaguru.java2.realestate.acceptancetests;

import static org.junit.Assert.assertEquals;

import lv.javaguru.java2.realestate.config.RealEstateConfiguration;
import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;
import lv.javaguru.java2.realestate.core.services.CreateOfferService;
import lv.javaguru.java2.realestate.core.services.GetAllOffersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AcceptanceTest1 {

    private ApplicationContext applicationContext;

    @Before
    public void setup(){
        applicationContext = new AnnotationConfigApplicationContext(RealEstateConfiguration.class);
    }

    @Test
    public void shouldReturnOfferList() {
        CreateOfferRequest createOfferRequest1 = new CreateOfferRequest(
                "offerType1", "offerCategory1", "Description1", 10.0);
        getCreateOfferService().execute(createOfferRequest1);

        CreateOfferRequest createOfferRequest2 = new CreateOfferRequest(
                "offerType2", "offerCategory2", "Description2", 10.0);
        getCreateOfferService().execute(createOfferRequest2);

        GetAllOffersResponse response = getAllOffersService().execute(new GetAllOffersRequest());
        assertEquals(response.getOfferList().size(), 2);
    }

    private CreateOfferService getCreateOfferService() { return applicationContext.getBean(CreateOfferService.class); }

    private GetAllOffersService getAllOffersService() { return applicationContext.getBean(GetAllOffersService.class); }
}
