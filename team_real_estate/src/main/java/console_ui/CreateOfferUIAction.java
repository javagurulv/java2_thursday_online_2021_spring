package console_ui;

import real_estate_app.Database;
import real_estate_app.Offer;
import real_estate_app.ConsoleUI;

import java.util.Scanner;

class CreateOfferUIAction implements ConsoleUI {
    private final Database database;
    private static final Scanner scanner = new Scanner(System.in);

    public CreateOfferUIAction(Database database) {
        this.database = database;
    }

    @Override
    public void execute() {
        System.out.println("Enter offer type (Buy/Sell/Rent) : ");
        String offerType = scanner.nextLine();
        System.out.println("Enter property category (Land/House/Flat : ");
        String propertyCategory = scanner.nextLine();
        System.out.println("Type in offer description : ");
        String description = scanner.nextLine();
        System.out.println("Enter price : ");
        int price = scanner.nextInt();

        database.createOffer(new Offer(offerType,propertyCategory,description,price));
    }
}
