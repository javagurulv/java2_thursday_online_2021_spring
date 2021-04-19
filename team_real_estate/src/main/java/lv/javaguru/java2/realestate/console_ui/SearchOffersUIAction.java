package lv.javaguru.java2.realestate.console_ui;

import lv.javaguru.java2.realestate.core.requests.SearchOffersRequest;
import lv.javaguru.java2.realestate.core.response.SearchOffersResponse;
import lv.javaguru.java2.realestate.core.services.SearchOffersService;

import java.util.Scanner;

public class SearchOffersUIAction implements ConsoleUI {

    SearchOffersService searchOffersService;

    public SearchOffersUIAction(SearchOffersService searchOffersService) {
        this.searchOffersService = searchOffersService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to skip field");

        System.out.println("Enter Offer type");
        String type = scanner.nextLine();
        System.out.println("Enter Offer category");
        String category = scanner.nextLine();
        System.out.println("Enter Offer price");
        Double price = scanner.nextDouble();
        System.out.println("Enter Offer id");
        Integer id = scanner.nextInt();

        SearchOffersRequest request = new SearchOffersRequest(type, category, price, id);
        SearchOffersResponse response = searchOffersService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getFoundOffers().forEach(offer -> System.out.println(offer.toString()));
        }
    }

}

