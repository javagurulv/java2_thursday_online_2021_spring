package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;
import lv.javaguru.java2.realestate.core.services.DeleteOfferService;

import java.util.Scanner;

public class DeleteOfferUIAction implements ConsoleUI {
    DeleteOfferService deleteOfferService;

    public DeleteOfferUIAction(DeleteOfferService deleteOfferService) {
        this.deleteOfferService = deleteOfferService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter offer ID : ");
        Integer offerID = scanner.nextInt();

        DeleteOfferRequest request = new DeleteOfferRequest(offerID);
        DeleteOfferResponse response = deleteOfferService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println("Offer deleted :  " + response.isOfferDeleted());
        }
    }
}
