package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;
import lv.javaguru.java2.realestate.core.services.GetAllOffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllOffersUIAction implements ConsoleUI {
    @Autowired
    private GetAllOffersService getAllOffersService;

    @Override
    public void execute() {
        System.out.println("Offer list : ");
        GetAllOffersRequest request = new GetAllOffersRequest();
        GetAllOffersResponse response = getAllOffersService.execute(request);
        response.getOfferList().forEach(offer -> System.out.println(offer.toString()));

    }
}
