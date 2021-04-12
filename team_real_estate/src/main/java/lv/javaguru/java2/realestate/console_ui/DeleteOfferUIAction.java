package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.services.DeleteOfferService;

import java.util.Scanner;

public class DeleteOfferUIAction implements ConsoleUI{
    DeleteOfferService deleteOfferService;

    public DeleteOfferUIAction(DeleteOfferService deleteOfferService) {
        this.deleteOfferService = deleteOfferService;
    }

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

        deleteOfferService.execute(offerType,propertyCategory,description,price);

    }
}
