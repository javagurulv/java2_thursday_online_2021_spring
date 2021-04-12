package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.services.GetAllOffersService;

class GetAllOffersUIAction implements ConsoleUI {
    GetAllOffersService getAllOffersService;

    public GetAllOffersUIAction(GetAllOffersService getAllOffersService) {
        this.getAllOffersService = getAllOffersService;
    }

    @Override
    public void execute() {
        getAllOffersService.execute().forEach(offer -> System.out.println(offer.toString()));
    }
}
