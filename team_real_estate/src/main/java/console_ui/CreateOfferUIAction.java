package console_ui;

import services.CreateOfferService;
import java.util.Scanner;

class CreateOfferUIAction implements ConsoleUI {


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter offer type (Buy/Sell/Rent) : ");
        String offerType = scanner.nextLine();
        System.out.println("Enter property category (Land/House/Flat : ");
        String propertyCategory = scanner.nextLine();
        System.out.println("Type in offer description : ");
        String description = scanner.nextLine();
        System.out.println("Enter price : ");
        int price = scanner.nextInt();

        new CreateOfferService().execute(offerType,propertyCategory,description,price);
        System.out.println("Offer created");
        scanner.close();
    }
}
