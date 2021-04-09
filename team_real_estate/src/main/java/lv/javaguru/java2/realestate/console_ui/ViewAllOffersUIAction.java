package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.services.ViewAllOffersService;

class ViewAllOffersUIAction implements ConsoleUI {

    @Override
    public void execute() {
        new ViewAllOffersService().execute().forEach(offer -> System.out.println(offer.toString()));
    }
}
