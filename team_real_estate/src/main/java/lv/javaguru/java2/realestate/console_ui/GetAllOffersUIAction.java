package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;
import lv.javaguru.java2.realestate.core.services.GetAllOffersService;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

@DIComponent
public class GetAllOffersUIAction implements ConsoleUI {
    @DIDependency
    private GetAllOffersService getAllOffersService;

    @Override
    public void execute() {
        System.out.println("Offer list : ");
        GetAllOffersRequest request = new GetAllOffersRequest();
        GetAllOffersResponse response = getAllOffersService.execute(request);
        response.getOfferList().forEach(offer -> System.out.println(offer.toString()));

    }
}
