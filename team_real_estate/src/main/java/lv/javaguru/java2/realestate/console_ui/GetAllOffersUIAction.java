package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.GetAllOffersRequest;
import lv.javaguru.java2.realestate.core.response.GetAllOffersResponse;
import lv.javaguru.java2.realestate.core.services.GetAllOffersService;

class GetAllOffersUIAction implements ConsoleUI {
    GetAllOffersService getAllOffersService;

    public GetAllOffersUIAction(GetAllOffersService getAllOffersService) {
        this.getAllOffersService = getAllOffersService;
    }

    @Override
    public void execute() {
        System.out.println("Offer list : ");
        GetAllOffersRequest request = new GetAllOffersRequest();
        GetAllOffersResponse response = getAllOffersService.execute(request);
        response.getOfferList().forEach(offer -> System.out.println(offer.toString()));

    }
}