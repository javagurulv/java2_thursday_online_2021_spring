package console_ui;

import services.ViewAllOffersService;

class ViewAllOffersUIAction implements ConsoleUI {

    @Override
    public void execute() {
        new ViewAllOffersService().execute().forEach(offer -> System.out.println(offer.toString()));
    }
}
