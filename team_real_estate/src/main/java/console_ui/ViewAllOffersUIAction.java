package console_ui;

import real_estate_app.Database;
import real_estate_app.ConsoleUI;

class ViewAllOffersUIAction implements ConsoleUI {
    private final Database database;

    public ViewAllOffersUIAction(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.viewAllOffers().forEach(offer -> System.out.println(offer.toString()));
    }
}
