package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.DeleteOfferRequest;
import lv.javaguru.java2.realestate.core.response.DeleteOfferResponse;
import lv.javaguru.java2.realestate.core.services.DeleteOfferService;
import lv.javaguru.java2.realestate.dependency_injection.DIComponent;
import lv.javaguru.java2.realestate.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class DeleteOfferUIAction implements ConsoleUI {
    @DIDependency
    private DeleteOfferService deleteOfferService;

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
