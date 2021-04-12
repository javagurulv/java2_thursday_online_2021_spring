package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;
import lv.javaguru.java2.realestate.core.services.CreateOfferService;

import java.util.Scanner;

class CreateOfferUIAction implements ConsoleUI {

    CreateOfferService createOfferService;

    public CreateOfferUIAction(CreateOfferService createOfferService){
        this.createOfferService = createOfferService;
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

        CreateOfferRequest request = new CreateOfferRequest(offerType,propertyCategory,description,price);
        CreateOfferResponse response = createOfferService.execute(request);


    }
}
