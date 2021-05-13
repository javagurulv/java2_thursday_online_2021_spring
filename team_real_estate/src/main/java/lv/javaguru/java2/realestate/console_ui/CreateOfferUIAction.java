package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.CreateOfferRequest;
import lv.javaguru.java2.realestate.core.response.CreateOfferResponse;
import lv.javaguru.java2.realestate.core.services.CreateOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateOfferUIAction implements ConsoleUI {

    @Autowired
    private CreateOfferService createOfferService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter offer type (Buy/Sell/Rent) : ");
        String offerType = scanner.nextLine();
        System.out.println("Enter offer category (Land/House/Flat : ");
        String offerCategory = scanner.nextLine();
        System.out.println("Type in offer description : ");
        String description = scanner.nextLine();
        System.out.println("Enter price : ");
        Double price = scanner.nextDouble();


        CreateOfferRequest request = new CreateOfferRequest(offerType, offerCategory, description, price);
        CreateOfferResponse response = createOfferService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Offer id : " + response.getOffer().getId());
            System.out.println("Offer created");
        }
    }
}
